package  View;

import Controller.UserController;
import Model.Egress;
import Model.User;
import Model.UserSerializable;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        UserController userController = new UserController();
        UserSerializable serializable = new UserSerializable();

        User user1 = new User("William", "william@unesp.com", "senha123");
        Egress egress1 = new Egress("Karol", "karol@unesp.com", "senha456", new Date(), new Date(), new Date(),
                new ArrayList<>(), "public");

        serializable.addUser(user1, userController.getUsers());
        serializable.addUser(egress1, userController.getUsers());

        User user2 = new User("rogerio", "karol@unesp.com", "senha789");
        serializable.addUser(user2, userController.getUsers());
        
        MainFrame myFrame = new MainFrame();
        myFrame.init();
    }
}
