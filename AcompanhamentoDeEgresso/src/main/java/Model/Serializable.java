package  Model;

public interface Serializable {
    boolean emailCheck(String email, java.util.List<User> users);

    void addUser(User user, java.util.List<User> users);
}
