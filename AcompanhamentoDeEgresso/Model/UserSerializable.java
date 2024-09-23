import java.util.List;

public class UserSerializable implements Serializable {

    @Override
    public boolean emailCheck(String email, List<User> users) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void addUser(User user, List<User> users) {
        if (!emailCheck(user.getEmail(), users)) {
            users.add(user);
            System.out.println("Usuario adicionado com sucesso: " + user.getName());
        } else {
            System.out.println("Email ja existe: " + user.getEmail());
        }
    }
}
