package  Model;
import java.util.Date;
import java.util.List;

public interface Serializable {
    boolean emailCheck(String email, java.util.List<User> users);

    void addUser(User user, java.util.List<User> users);
    
    boolean login(String email, String password, List<User> users);
    
    void updateEgress(Date birthDate, Date startDate, Date endDate, String[] socialMedia, boolean visibility, List<User> users);
    
    void updateEgress(String email, String password, Date birthDate, Date startDate, Date endDate, String[] socialMedia, boolean visibility, List<User> users);
}
