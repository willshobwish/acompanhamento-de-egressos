package Controller;

import Model.Administrator;
import Model.Egress;
import Model.Milestone;
import Model.User;
import Serializables.SerializableSystem;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

// SINGLETON PROTOTYPE, NOT FINAL
public class SystemController {

    private static final Logger logger = Logger.getLogger(SystemController.class.getName());
    private static SystemController instance;
    private static SerializableSystem serializableSystem = SerializableSystem.getInstance();
    private User userSession = null;
    private Administrator admin = new Administrator();

    private SystemController() {
    }

    public static SystemController getInstance() {
        if (instance == null) {
            instance = new SystemController();
        }
        return instance;
    }

    public User getUserSession() {
        return userSession;
    }

    public void logout() {
        this.userSession = null;
    }

    public ArrayList<Egress> getEgresses() {
        ArrayList<User> users = serializableSystem.loadUser();
        ArrayList<Egress> egresses = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Egress) {
                egresses.add((Egress) user);
            }
        }
        return egresses;
    }

    public static String generatePassword() {
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(90000);
        logger.info("Senha gerada: " + randomNumber);
        return String.valueOf(randomNumber);
    }

    // User Management
    public String createUser(String name, String email, char type) {
        if (emailExist(email)) {
            logger.info("Error: Email already exists.");
            return "";
        }

//        User newUser;
        String password = generatePassword();
//        if (type == 'U') {
//            newUser = new User(name, email, password);
//        } else {
//            logger.info("Error: Invalid user type.");
//            return "";
//        }
        ArrayList<User> users = serializableSystem.loadUser();
        users.add(new User(name, email, password));
        logger.info("Usuario criado: " + name + " / " + email);
        serializableSystem.saveUsers(users);
        return password;
    }

    public Egress getEgressByEmail(String email) {
        ArrayList<User> users = serializableSystem.loadUser();
        for (User user : users) {
            if (user instanceof Egress) {
                if (user.getEmail().equals(email)) {
                    return (Egress) user;
                }
            }
        }
        return null;
    }

    public String createEgress(String name, String email, char type) {
        if (emailExist(email)) {
            logger.info("Error: Email already exists.");
            return "";
        }

        Egress newUser;
        String password = generatePassword();
//        if (type == 'E') {
//            password = generatePassword();
        ArrayList<String> lst = new ArrayList<>();
        lst.add(" ");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        newUser = new Egress(name, email, password,
                LocalDate.from(formatter.parse("01/01/1899")),
                LocalDate.from(formatter.parse("01/01/1899")),
                LocalDate.from(formatter.parse("01/01/1899")),
                lst,
                false);
//        } else {
//            logger.info("Error: Invalid user type.");
//            return "";
//        }
        ArrayList<User> egresses = serializableSystem.loadUser();
        egresses.add(newUser);
        serializableSystem.saveUsers(egresses);
        logger.info("Usuario criado: " + name + " / " + email);
        return password;
    }

    public void createEgressFull(String name, String email, char type, LocalDate birthDate,
            LocalDate startDate, LocalDate endDate, ArrayList<String> socialMedia, boolean isPublic) {
        if (emailExist(email)) {
            logger.info("Error: Email already exists.");
            return;
        }

        Egress newUser;
        if (type == 'E') {
            newUser = new Egress(name, email, generatePassword(), birthDate, startDate, endDate, socialMedia, isPublic);
        } else {
            logger.info("Error: Invalid user type.");
            return;
        }
        newUser.setFirstAccess(false);
        ArrayList<User> egresses = serializableSystem.loadUser();
        egresses.add(newUser);
        serializableSystem.saveUsers(egresses);
        logger.info("Usuario criado: " + name + " / " + email);
    }

    public boolean emailExist(String email) {
        ArrayList<User> users = serializableSystem.loadUser();
        for (User user : users) {
            if (user instanceof Egress) {
                if (user.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void login(String email, String password) {
        logger.info(email + " " + password);
        if (admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
            userSession = admin;
            logger.info("Administrator Login Successful");
            return;
        }
        ArrayList<User> users = serializableSystem.loadUser();
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                userSession = user;
                logger.info(userSession.getEmail());
                logger.info("Login successful for: " + user.getName());
                return;
            }
        }
//        for (Egress egress : egresses) {
//            if (egress.getEmail().equals(email) && egress.getPassword().equals(password)) {
//                userSession = egress;
//                logger.info(userSession.getEmail());
//                logger.info("Login successful for: " + egress.getName());
//                return;
//            }
//        }
        logger.info("Error: Invalid email or password.");
    }

    // Egress Management
    public void updateEgress(LocalDate birthDate, LocalDate startDate, LocalDate endDate, ArrayList<String> socialMedia, boolean isPublic) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }

        ArrayList<User> users = serializableSystem.loadUser();
        Egress existingEgress = getEgressByEmail(userSession.getEmail());

        if (existingEgress == null) {
            logger.info("Error: Egress not found.");
            return;
        }

        existingEgress.setBirthDate(birthDate);
        existingEgress.setStartDate(startDate);
        existingEgress.setEndDate(endDate);
        existingEgress.setSocialMedias(socialMedia);
        existingEgress.setPublicProfile(isPublic);
        existingEgress.setFirstAccess(false);

        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) instanceof Egress && ((Egress) users.get(i)).getEmail().equals(userSession.getEmail())) {
                users.set(i, existingEgress);
                break;
            }
        }

        serializableSystem.saveUsers(users);
        logger.info("Egress updated successfully: " + userSession.getName());
    }

    public void admUpdateEgress(Egress egress, LocalDate birthDate, LocalDate startDate, LocalDate endDate, ArrayList<String> socialMedia, boolean isPublic) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }
        egress.setBirthDate(birthDate);
        egress.setStartDate(startDate);
        egress.setEndDate(endDate);
        egress.setSocialMedias(socialMedia);
        egress.setPublicProfile(isPublic);

        logger.info("Egress updated successfully: " + egress.getName());
    }

    public void saveEgress(Egress egress) {
        ArrayList<User> users = serializableSystem.loadUser();
        if (!users.contains(egress)) {
            users.add(egress);
            logger.info("Egress saved successfully.");
        } else {
            logger.info("Error: Egress already exists.");
        }
    }

    // Password Management
    public boolean updatePassword(String newPassword) {
        if (userSession == null) {
            logger.info("Error: No user logged in.");
            return false;
        }

        userSession.setPassword(newPassword);
        logger.info("Password updated successfully.");
        return true;
    }

    // Milestone Management
    public void createMilestone(String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.getTrajectory().addMilestone(institution, description, role, startDate, finishDate, current);
        logger.info("Milestone created successfully for: " + egress.getName());
    }

    public void updateMilestone(String id, String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.getTrajectory().updateMilestone(id, institution, description, role, startDate, finishDate, current);
        logger.info("Milestone updated successfully for: " + egress.getName());
    }

    public void deleteMilestone(String id) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.getTrajectory().deleteMilestone(id);
        logger.info("Milestone deleted successfully for: " + egress.getName());
    }

    // Validation and Pending Milestone Management
    public void validateMilestone(Milestone newMilestone, Egress egress, boolean approved) {
        if (egress == null || newMilestone == null) {
            logger.info("Error: Invalid Egress or Milestone.");
            return;
        }

        if (approved) {
            egress.getTrajectory().setMilestone(newMilestone);
            logger.info("Milestone approved for: " + egress.getName());
        } else {
            logger.info("Milestone rejected for: " + egress.getName());
        }
//        pendentMilestones.removeIf(pm -> pm.getNewMilestone().equals(newMilestone));
    }

    public List<Milestone> listPendentsMilestones() {
        ArrayList<User> users = serializableSystem.loadUser();
        ArrayList<Milestone> milestones = new ArrayList<>();
        ArrayList<Milestone> pendentMilestone = new ArrayList<>();

        for (User user : users) {
            if (user instanceof Egress) {
                milestones = user.getMilestones();
            }
        }
//        List<Milestone> milestones = new ArrayList<>();
        for (Milestone pendent : milestones) {
            if (!pendent.isValidate()) {
                pendentMilestone.add(pendent);
            }

        }
        return milestones;
    }

    public void removePendentMilestoneFromList(Milestone milestone) {
//        pendentMilestones.removeIf(pm -> pm.getNewMilestone().equals(milestone));
        logger.info("Milestone removed from pending list.");
    }
}
