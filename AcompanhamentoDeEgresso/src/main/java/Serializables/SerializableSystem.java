package Serializables;

import Model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class SerializableSystem {

    private static SerializableSystem instance;
    private static final Logger logger = Logger.getLogger(SerializableSystem.class.getName());

    public static SerializableSystem getInstance() {
        if (instance == null) {
            synchronized (SerializableSystem.class) {
                if (instance == null) {
                    instance = new SerializableSystem();
                }
            }
        }
        return instance;
    }

    public boolean saveUsers(ArrayList<User> users) {
        String filePath = Paths.get("").toAbsolutePath().toString() + "/src/main/java/Files/user.bin";
        File file = new File(filePath);
        try {
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                logger.info("Creating directories: " + parentDir);
                if (!parentDir.mkdirs()) {
                    logger.log(Level.SEVERE, "Failed to create directories.");
                    return false;
                }
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(users);
                logger.info("Users saved successfully.");
                return true;
            } catch (IOException e) {
                logger.log(Level.SEVERE, "Error during serialization: " + e.getMessage());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error: " + e.getMessage());
        }
        return false;
    }

    public ArrayList<User> loadUsers() {
        String filePath = Paths.get("").toAbsolutePath().toString() + "/src/main/java/Files/user.bin";
        File file = new File(filePath);

        ArrayList<User> users = new ArrayList<>();

        try {
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                logger.info("Creating directories: " + parentDir);
                if (!parentDir.mkdirs()) {
                    logger.log(Level.SEVERE, "Failed to create directories.");
                    return users;
                }
            }

            if (!file.exists()) {
                logger.info("File does not exist: " + filePath);
                return users;
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (ArrayList<User>) ois.readObject();
                logger.info("Objects deserialized successfully.");
            } catch (IOException | ClassNotFoundException e) {
                logger.log(Level.SEVERE, "Error during deserialization: " + e.getMessage());
            }
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Unexpected error: " + e.getMessage());
        }

        return users;
    }
    
    public User findUser(String email, String password){
        
        ArrayList<User> users = this.loadUsers();
        for(User userList: users){
            if(userList.getEmail().equals(email) && userList.getPassword().equals(password)){
                return userList;
            }
        }
        
        return null;
    } 

}
