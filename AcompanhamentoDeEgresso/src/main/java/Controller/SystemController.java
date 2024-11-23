package Controller;

import Serializable.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class SystemController {
    private Serializable serializable;

    public SystemController(Serializable serializable) {
        this.serializable = serializable;
    }

    public String createUser(String name, String email, char type) {
        serializable.createUser(name, email, type);
        return "User created successfully";
    }

    public void login(String email, String password) {
        serializable.login(email, password);
    }

    public void updateEgress(LocalDate birthDate, LocalDate startDate, LocalDate endDate, ArrayList<String> socialMedia, boolean isPublic) {
        serializable.updateEgress(birthDate, startDate, endDate, socialMedia, isPublic);
    }
    
    public void createMilestone(String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        serializable.createMilestone(institution, description, role, startDate, finishDate, current);
    }

    public void deleteMilestone(String id) {
        serializable.deleteMilestone(id);
    }
}
