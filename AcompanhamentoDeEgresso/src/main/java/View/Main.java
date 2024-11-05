package  View;

import Controller.UserController;
import Model.User;
import Model.UserSerializable;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        UserSerializable serializable = new UserSerializable();

        /*
        Egress egress1 = new Egress("Karol", "karol@unesp.com", "senha456", new Date(), new Date(), new Date(), new ArrayList<>(), "public");
        serializable.addUser(egress1, userController.getUsers());
        User user2 = new User("rogerio", "karol@unesp.com", "senha789");
        serializable.addUser(user2, userController.getUsers());
        */
        
        List<User> users = new ArrayList<>();
        User admin = new User("admin", "admin", "admin");
        serializable.addUser(admin, users);
        LoginScreen loginScreen = new LoginScreen(users);
        loginScreen.setVisible(true);
        MainFrame myFrame = new MainFrame();
        myFrame.init();
    }
}
