package  Model;
import java.util.Date;
import java.util.List;

public interface Serializable {
    /* OLD
    boolean emailCheck(String email, java.util.List<User> users);

    void addUser(User user, java.util.List<User> users);
    
    boolean login(String email, String password, List<User> users);
    
    void updateEgress(Date birthDate, Date startDate, Date endDate, List<String> socialMedia, boolean visibility, List<User> users);
    
    void updateEgress(String email, String password, Date birthDate, Date startDate, Date endDate, List<String> socialMedia, boolean visibility, List<User> users);
    */
    
    User userSession = null;

    // User Management
    void createUser(String name, String email, char type);
    boolean emailExist(String email);
    void login(String email, String password);

    // Egress Management
    void updateEgress(Date birthDate, Date startDate, Date endDate, List<String> socialMedia, boolean isPublic);
    void saveEgress(Egress egress);

    // Password Management
    boolean updatePassword(String newPassword);

    // Milestone Management
    void createMilestone(String institution, String description, String role, Date startDate, Date finishDate, boolean current);
    void updateMilestone(String id, String institution, String description, String role, Date startDate, Date finishDate, boolean current);
    void deleteMilestone(String id);

    // Validation and Pending Milestone Management
    void validateMilestone(Milestone newMilestone, Egress egress, boolean approved);
    List<Milestone> listPendentsMilestones();
    void removePendentMilestoneFromList(Milestone milestone);

}
