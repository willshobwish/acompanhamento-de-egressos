package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class User implements Serializable {

    private String name;
    private String email;
    private String password;
    private ArrayList<Milestone> milestones;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        this.password = this.generatePassword();
        this.milestones = new ArrayList<>();
    }

    private String generatePassword() {
        Random random = new Random();
        int randomNumber = 10000 + random.nextInt(99999);
        return String.valueOf(randomNumber);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void updatePassword(String password) {
        this.password = password;
    }

    public ArrayList<Milestone> getMilestones() {
        return milestones;
    }

    public void setMilestones(ArrayList<Milestone> milestones) {
        this.milestones = milestones;
    }

    @Override
    public String toString() {
        String string = """
              Name: %s
              Email: %s
              Password: %s
              Milestones: %s
              """.formatted(name, email, password, Arrays.toString(milestones.toArray()));
        return string;
    }
}
