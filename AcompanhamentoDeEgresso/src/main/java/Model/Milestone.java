package Model;

import java.util.Date;
import java.util.UUID;

public class Milestone {
    private String id;
    private String institution;
    private String description;
    private String role;
    private Date startDate;
    private Date finishDate;
    private boolean current;

    public Milestone(String institution, String description, String role, Date startDate, Date finishDate, boolean current) {
        this.id = UUID.randomUUID().toString(); // Generate a unique ID
        this.institution = institution;
        this.description = description;
        this.role = role;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.current = current;
    }


    public String getId() {
        return id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public boolean isCurrent() {
        return current;
    }

    public void setCurrent(boolean current) {
        this.current = current;
    }
}
