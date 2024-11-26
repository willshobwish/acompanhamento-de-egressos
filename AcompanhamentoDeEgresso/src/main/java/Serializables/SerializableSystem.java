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

/**
 *
 * @author Administrator
 */
public class SerializableSystem {

    private static SerializableSystem instance;
//    final private String path;

    public static SerializableSystem getInstance() {
        if (instance == null) {
            synchronized (SerializableSystem.class) { // Thread-safe initialization
                if (instance == null) {
                    instance = new SerializableSystem();
                }
            }
        }
        return instance;
    }

//    public SerializableSystem(String fileName) {
//        Path currentDir = Paths.get("").toAbsolutePath();
//        String filePath = currentDir.toString() + "/src/main/java/Files/" + fileName;
//        this.path = filePath;
//        initializeFileIfEmpty();
//    }
//    public void writeObjects(List<?> objects) throws Exception {
//        try (FileOutputStream fout = new FileOutputStream(this.path, false); ObjectOutputStream oos = new ObjectOutputStream(fout)) {
//
//            oos.writeObject(objects);
//
//        } catch (IOException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
//
//    private void initializeFileIfEmpty() {
//        File file = new File(this.path);
//
//        if (!file.exists() || file.length() == 0) {
//            try (FileOutputStream fout = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fout)) {
//                oos.writeObject(new ArrayList<>());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public List<?> readObjects() throws Exception {
//        File file = new File(this.path);
//        if (!file.exists() || file.length() == 0) {
//            return new ArrayList<>();
//        }
//
//        try (FileInputStream fin = new FileInputStream(this.path); ObjectInputStream ois = new ObjectInputStream(fin)) {
//
//            return (List<Object>) ois.readObject();
//
//        } catch (EOFException e) {
//            System.out.println("Arquivo vazio. Retornando uma lista vazia.");
//            return new ArrayList<>();
//        } catch (IOException | ClassNotFoundException ex) {
//            ex.printStackTrace();
//            throw ex;
//        }
//    }
    public boolean saveUsers(ArrayList<User> users) {
        String filePath = Paths.get("").toAbsolutePath().toString() + "/src/main/java/Files/user.bin";
        File file = new File(filePath);
        try {
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                System.out.println("Creating directories: " + parentDir);
                if (!parentDir.mkdirs()) {
                    System.err.println("Failed to create directories.");
                    return false;
                }
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
                oos.writeObject(users);
                System.out.println("Users saved successfully.");
                return true;
            } catch (IOException e) {
                System.err.println("Error during serialization: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<User> loadUser() {
        String filePath = Paths.get("").toAbsolutePath().toString() + "/src/main/java/Files/user.bin";
        File file = new File(filePath);

        ArrayList<User> users = new ArrayList<>();

        try {
            File parentDir = file.getParentFile();
            if (!parentDir.exists()) {
                System.out.println("Creating directories: " + parentDir);
                if (!parentDir.mkdirs()) {
                    System.err.println("Failed to create directories.");
                    return users;
                }
            }

            if (!file.exists()) {
                System.out.println("File does not exist: " + filePath);
                return users;
            }

            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
                users = (ArrayList<User>) ois.readObject();
                System.out.println("Objects deserialized successfully.");
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error during deserialization: " + e.getMessage());
                e.printStackTrace();
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }

        return users;
    }
}
