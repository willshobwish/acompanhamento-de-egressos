package Serializables;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class SerializableObject {

    final private String path;

    public SerializableObject(String fileName) {
        Path currentDir = Paths.get("").toAbsolutePath();
        String filePath = currentDir.toString()+"/src/main/java/Files/"+fileName;
        this.path = filePath;
        initializeFileIfEmpty();
    }

    public void writeObjects(List<?> objects) throws Exception {
        try (FileOutputStream fout = new FileOutputStream(this.path, false); ObjectOutputStream oos = new ObjectOutputStream(fout)) {

            oos.writeObject(objects);

        } catch (IOException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    private void initializeFileIfEmpty() {
        File file = new File(this.path);

        if (!file.exists() || file.length() == 0) {
            try (FileOutputStream fout = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fout)) {
                oos.writeObject(new ArrayList<>());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<?> readObjects() throws Exception {
        File file = new File(this.path);
        if (!file.exists() || file.length() == 0) {
            return new ArrayList<>();
        }

        try (FileInputStream fin = new FileInputStream(this.path); ObjectInputStream ois = new ObjectInputStream(fin)) {

            return (List<Object>) ois.readObject();

        } catch (EOFException e) {
            System.out.println("Arquivo vazio. Retornando uma lista vazia.");
            return new ArrayList<>();
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            throw ex;
        }
    }
}
