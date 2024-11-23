package Serializable;

import Model.Administrator;
import Model.Egress;
import Model.Milestone;
import Model.PendentMilestone;
import Model.User;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Serializable {
    private List<User> users = new ArrayList<>();
    private List<PendentMilestone> pendentMilestones = new ArrayList<>();
    private User userSession;

    // User Management
    public void createUser(String name, String email, char type) {
        if (emailExist(email)) {
            System.out.println("Error: Email already exists.");
            return;
        }

        User newUser;
        if (type == 'E') {
            newUser = new Egress(name, email, "default123", null, null, null, new ArrayList<>(), false);
        } else if (type == 'A') {
            newUser = new Administrator(name, email, "admin");
        } else {
            System.out.println("Error: Invalid user type.");
            return;
        }

        users.add(newUser);
        System.out.println("User created successfully: " + name);
    }

    public boolean emailExist(String email) {
        for (User user : users) {
            if (user.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public void login(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                userSession = user;
                System.out.println("Login successful for: " + user.getName());
                return;
            }
        }
        System.out.println("Error: Invalid email or password.");
    }

    // Egress Management
    public void updateEgress(LocalDate birthDate, LocalDate startDate, LocalDate endDate, ArrayList<String> socialMedia, boolean isPublic) {
        if (!(userSession instanceof Egress)) {
            System.out.println("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.setBirthDate(birthDate);
        egress.setStartDate(startDate);
        egress.setEndDate(endDate);
        egress.setSocialMedias(socialMedia);
        egress.setIsPublic(isPublic);

        System.out.println("Egress updated successfully: " + egress.getName());
    }

    public void saveEgress(Egress egress) {
        if (!users.contains(egress)) {
            users.add(egress);
            System.out.println("Egress saved successfully.");
        } else {
            System.out.println("Error: Egress already exists.");
        }
    }

    // Password Management
    public boolean updatePassword(String newPassword) {
        if (userSession == null) {
            System.out.println("Error: No user logged in.");
            return false;
        }

        userSession.setPassword(newPassword);
        System.out.println("Password updated successfully.");
        return true;
    }

    // Milestone Management
    public void createMilestone(String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        if (!(userSession instanceof Egress)) {
            System.out.println("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.getTrajectory().addMilestone(institution, description, role, startDate, finishDate, current);
        System.out.println("Milestone created successfully for: " + egress.getName());
    }

    public void updateMilestone(String id, String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        if (!(userSession instanceof Egress)) {
            System.out.println("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.getTrajectory().updateMilestone(id, institution, description, role, startDate, finishDate, current);
        System.out.println("Milestone updated successfully for: " + egress.getName());
    }

    public void deleteMilestone(String id) {
        if (!(userSession instanceof Egress)) {
            System.out.println("Error: Logged-in user is not an Egress.");
            return;
        }

        Egress egress = (Egress) userSession;
        egress.getTrajectory().deleteMilestone(id);
        System.out.println("Milestone deleted successfully for: " + egress.getName());
    }

    // Validation and Pending Milestone Management
    public void validateMilestone(Milestone newMilestone, Egress egress, boolean approved) {
        if (egress == null || newMilestone == null) {
            System.out.println("Error: Invalid Egress or Milestone.");
            return;
        }

        if (approved) {
            egress.getTrajectory().setMilestone(newMilestone);
            System.out.println("Milestone approved for: " + egress.getName());
        } else {
            System.out.println("Milestone rejected for: " + egress.getName());
        }

        pendentMilestones.removeIf(pm -> pm.getNewMilestone().equals(newMilestone));
    }

    public List<Milestone> listPendentsMilestones() {
        List<Milestone> milestones = new ArrayList<>();
        for (PendentMilestone pm : pendentMilestones) {
            milestones.add(pm.getNewMilestone());
        }
        return milestones;
    }

    public void removePendentMilestoneFromList(Milestone milestone) {
        pendentMilestones.removeIf(pm -> pm.getNewMilestone().equals(milestone));
        System.out.println("Milestone removed from pending list.");
    }
}
