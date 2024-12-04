package Controller;

import Model.Administrator;
import Model.Egress;
import Model.Milestone;
import Model.MilestoneSubmission;
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
        String message = "";

        for (String key : fields.keySet()) {
            if (fields.get(key).isBlank()) {
                message += ("Campo " + key + " não pode ser vazio. \n");
            }
        }

        return message;
    }

    public String createEgress(String name, String email, LocalDate startDate, LocalDate endDate) {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Nome", name);
        fields.put("Email", email);
        fields.put("Data de ingresso", startDate == null ? "" : startDate.toString());
        fields.put("Data de egresso", endDate == null ? "" : endDate.toString());

        String emptyFields = emptyDataCheck(fields);
        if (!emptyFields.isBlank()) {
            logger.info("Error: Fields empty");
            return emptyFields;
        }

        if (emailExist(email)) {
            logger.info("Error: Email already exists.");
            return "Esse email já existe, por favor insira outro.";
        }

        User user = new Egress(name, email, startDate, endDate);

        logger.log(Level.INFO, "Usuario criado: {0} / {1}", new Object[]{name, email});
        storage.saveUser(user);
        return "Egresso criado com sucesso. Acesse com o email e a senha: " + user.getPassword();
    }

    public String createUser(String name, String email) {
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

        User user = new User(name, email);

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

    public String updateEgress(String name, LocalDate birthDate, ArrayList<String> socialMedias, boolean publicProfile) {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Nome", name);
        fields.put("Data de nascimento", birthDate == null ? "" : birthDate.toString());
        fields.put("Primeira social media", socialMedias.get(0));
        fields.put("Perfil público", Boolean.toString(publicProfile));

        String emptyFields = emptyDataCheck(fields);
        if (!emptyFields.isBlank()) {
            logger.info("Error: Fields empty");
            return emptyFields;
        }

        ((Egress) userSession).updateData(name, birthDate, socialMedias, publicProfile);
        storage.updateUser(userSession);
        logger.log(Level.INFO, "Egress updated successfully: {0}", userSession.getName());

        return "Dados atualizados com sucesso!";
    }

    public String completeProfile(LocalDate birthDate, ArrayList<String> socialMedias, boolean publicProfile) {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Data de nascimento", birthDate == null ? "" : birthDate.toString());
        fields.put("Primeira social media", socialMedias.get(0));
        fields.put("Perfil público", Boolean.toString(publicProfile));

        String emptyFields = emptyDataCheck(fields);
        if (!emptyFields.isBlank()) {
            logger.info("Error: Fields empty");
            return emptyFields;
        }

        ((Egress) userSession).completeProfile(birthDate, socialMedias, publicProfile);

        storage.updateUser(userSession);
        logger.log(Level.INFO, "Egress updated successfully: {0}", userSession.getName());

        return "Dados atualizados com sucesso!";
    }

    private boolean isPasswordValid(String password) {
        return password.length() >= 5;
    }

    public String updatePassword(String newPassword) {
        if (!isPasswordValid(newPassword)) {
            logger.info("Error: password invalid");
            return "A senha deve ter pelo menos cinco caracteres!";
        }

        userSession.updatePassword(newPassword);
        storage.updateUser(userSession);
        logger.info("Password updated successfully.");
        return "Senha atualizada com sucesso!";
    }

    // Milestone Management
    public String createMilestone(String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Instituição", institution);
        fields.put("Cargo/atividades", role);
        fields.put("Descrição das atividades", description);
        fields.put("Data de ínicio", startDate == null ? "" : startDate.toString());
        if (!current) {
            fields.put("Data de término", finishDate == null ? "" : finishDate.toString());
        }

        String emptyFields = emptyDataCheck(fields);
        if (!emptyFields.isBlank()) {
            logger.info("Error: Fields empty");
            return emptyFields;
        }

        Egress egress = (Egress) userSession;

        Milestone newMilestone = new Milestone(institution, description, role, startDate, finishDate, current);
        MilestoneSubmission newMilestoneSubmission = new MilestoneSubmission(egress, newMilestone, null);
        storage.saveMilestoneSubmission(newMilestoneSubmission);

        return "Marco criado com sucesso. Por favor aguarde a validação do Administrador. Você pode acompanhar o status da validação em Trajetória > Histórico de atualizações.";
    }

    public String updateMilestone(Milestone originalMilestone, String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        HashMap<String, String> fields = new HashMap<>();
        fields.put("Instituição", institution);
        fields.put("Cargo/atividades", role);
        fields.put("Descrição das atividades", description);
        fields.put("Data de ínicio", startDate == null ? "" : startDate.toString());
        if (!current) {
            fields.put("Data de término", finishDate == null ? "" : finishDate.toString());
        }

        String emptyFields = emptyDataCheck(fields);
        if (!emptyFields.isBlank()) {
            logger.info("Error: Fields empty");
            return emptyFields;
        }

        Egress egress = (Egress) userSession;

        Milestone newMilestone = new Milestone(institution, description, role, startDate, finishDate, current);
        MilestoneSubmission newMilestoneSubmission = new MilestoneSubmission(egress, newMilestone, originalMilestone);
        storage.saveMilestoneSubmission(newMilestoneSubmission);

        return "Marco atualizado com sucesso. Por favor aguarde a validação do Administrador. Você pode acompanhar o status da validação em Trajetória > Histórico de atualizações.";

    }

    public String deleteMilestone(Milestone milestone) {
        Egress egress = (Egress) userSession;
        egress.deleteMilestone(milestone);
        storage.updateUser(userSession);
        logger.log(Level.INFO, "Milestone deleted successfully for: {0}", egress.getName());
        return "Milestone excluída com sucesso!";
    }

    public String validateMilestone(MilestoneSubmission pendentMilestone, boolean approved) {

        pendentMilestone.updateStatus(approved ? "Aprovado" : "Recusado");
        Milestone newMilestone = pendentMilestone.getNewMilestone();
        Milestone oldMilestone = pendentMilestone.getOldMilestone();
        Egress egress = pendentMilestone.getEgress();

        if (approved && oldMilestone == null) {
            egress.addMilestone(newMilestone);
        }

        if (approved && oldMilestone != null) {
            egress.updateMilestone(oldMilestone, newMilestone);
        }

        storage.updateUser(egress);
        storage.updateMilestoneSubmission(pendentMilestone);

        logger.log(Level.INFO, "Milestone deleted successfully for: {0}", egress.getName());
        return "Marco validado com sucesso!";
    }

    public ArrayList<MilestoneSubmission> listPendentsMilestones() {
        if (userSession instanceof Administrator) {
            return storage.loadPendentMilestonesSubmissions();
        } else {
            return new ArrayList<>();
        }
    }

    public ArrayList<MilestoneSubmission> listMilestoneSubmissionsByEgress() {
        if (userSession instanceof Egress egress) {
            return storage.loadMilestonesSubmissionsByEgress(egress);
        }
        return new ArrayList<>();
    }

}
