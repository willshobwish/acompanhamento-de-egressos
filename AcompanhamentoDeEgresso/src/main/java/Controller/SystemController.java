package Controller;

import Model.*;

import java.util.Date;
import java.util.List;

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

    public void updateEgress(Date birthDate, Date startDate, Date endDate, List<String> socialMedia, boolean isPublic) {
        serializable.updateEgress(birthDate, startDate, endDate, socialMedia, isPublic);
    }
    
    public void createMilestone(String institution, String description, String role, Date startDate, Date finishDate, boolean current) {
        serializable.createMilestone(institution, description, role, startDate, finishDate, current);
    }

    public void deleteMilestone(String id) {
        serializable.deleteMilestone(id);
    }
}
