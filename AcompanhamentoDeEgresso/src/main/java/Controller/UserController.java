package  Controller;

import Model.User;
import java.util.ArrayList;
import java.util.List;

public class UserController {
    private List<User> users;

    public UserController() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public List<User> getUsers() {
        return users;
    }
}
