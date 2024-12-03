package Controller;

import Model.Administrator;
import Model.Egress;
import Model.Milestone;
import Model.PendentMilestone;
import Model.User;
import Serializables.SerializableSystem;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SystemController {
    
    private static final Logger logger = Logger.getLogger(SystemController.class.getName());
    private static SystemController instance;
    
    private static final SerializableSystem storage = SerializableSystem.getInstance();
    private User userSession = null;
    
    private SystemController() {
        if (!this.emailExist("admin")) {
            User adm = new Administrator();
            storage.saveUser(adm);
        }
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
        ArrayList<User> users = storage.loadUsers();
        ArrayList<Egress> egresses = new ArrayList<>();
        for (User user : users) {
            if (user instanceof Egress) {
                egresses.add((Egress) user);
            }
        }
        return egresses;
    }
    
    private String emptyDataCheck(HashMap<String, String> fields) {
        final String message = "";
        
        fields.keySet().forEach((key) -> {
            if (fields.get(key).isBlank()) {
                message.concat("Campo " + key + " não pode ser vazio./n");
            }
        });
        
        return message;
    }
    
    public String createUser(String name, String email, boolean isEgress) {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Nome", name);
        fields.put("Email", email);
        
        String emptyFields = emptyDataCheck(fields);
        if (!emptyFields.isBlank()) {
            logger.info("Error: Fields empty");
            return emptyFields;
        }
        
        if (emailExist(email)) {
            logger.info("Error: Email already exists.");
            return "Esse email já existe, por favor insira outro.";
        }
        
        User user;
        if (isEgress) {
            user = new Egress(name, email);
        } else {
            user = new User(name, email);
        }
        
        logger.log(Level.INFO, "Usuario criado: {0} / {1}", new Object[]{name, email});
        storage.saveUser(user);
        return "Usuário criado com sucesso. Acesse com o email e a senha: " + user.getPassword();
    }
    
    public Egress getEgressByEmail(String email) {
        ArrayList<User> users = storage.loadUsers();
        for (User user : users) {
            if (user instanceof Egress) {
                if (user.getEmail().equals(email)) {
                    return (Egress) user;
                }
            }
        }
        return null;
    }
    
    public boolean emailExist(String email) {
        ArrayList<User> users = storage.loadUsers();
        for (User user : users) {
            if (user instanceof Egress) {
                if (user.getEmail().equals(email)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean login(String email, String password) {
        logger.log(Level.INFO, "Login: {0} {1}", new Object[]{email, password});
        
        User user = storage.findUser(email, password);
        if (user != null) {
            setUserSession(user);
            return true;
        }
        logger.info("Login: Invalid email or password.");
        return false;
    }
    
    private void setUserSession(User user) {
        this.userSession = user;
    }

    // Egress Management
    public void updateEgress(LocalDate birthDate, LocalDate startDate, LocalDate endDate, ArrayList<String> socialMedia, boolean isPublic) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }
        
        ArrayList<User> users = storage.loadUsers();
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
        
        storage.saveUsers(users);
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
        ArrayList<User> users = storage.loadUsers();
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
        
        ArrayList<User> users = storage.loadUsers();
        
        for (User user : users) {
            if (user instanceof Administrator adm) {
                adm.createPendentMilestone(
                        null,
                        new Milestone(institution, description, role, startDate, finishDate, current),
                        egress);
            }
        }
        
        logger.info("Milestone created successfully for: " + egress.getName());
    }
    
    public void updateMilestone(String id, String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        if (!(userSession instanceof Egress)) {
            logger.info("Error: Logged-in user is not an Egress.");
            return;
        }
        
        Egress egress = (Egress) userSession;
        
        ArrayList<User> users = storage.loadUsers();
        
        for (User user : users) {
            if (user instanceof Administrator adm) {
                adm.createPendentMilestone(
                        egress.getTrajectory().getMilestoneById(id),
                        new Milestone(institution, description, role, startDate, finishDate, current),
                        egress);
            }
        }
        
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
    
    public ArrayList<PendentMilestone> listPendentsMilestones() {
        ArrayList<User> users = storage.loadUsers();
        
        for (User user : users) {
            if (user instanceof Administrator administrator) {
                return administrator.getPendentMilestones();
            }
        }
        
        return new ArrayList<>();
    }
    
    public ArrayList<PendentMilestone> listPendentsMilestonesByEgress() {
        ArrayList<PendentMilestone> egressPendentMilestones = new ArrayList<>();
        
        ArrayList<PendentMilestone> allPendentMilestones = listPendentsMilestones();
        
        for (PendentMilestone milestone : allPendentMilestones) {
            if (milestone.getEgress().getEmail().equals(this.userSession.getEmail())) {
                egressPendentMilestones.add(milestone);
            }
        }
        
        return egressPendentMilestones;
    }
    
    public void removePendentMilestoneFromList(Milestone milestone) {
//        pendentMilestones.removeIf(pm -> pm.getNewMilestone().equals(milestone));
        logger.info("Milestone removed from pending list.");
    }
}
