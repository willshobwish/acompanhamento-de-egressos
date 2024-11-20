package Model;

import java.util.Date;
import java.util.List;

public class Egress extends User {
    private Date birthDate;
    private Date startDate;
    private Date endDate;
    private List<String> socialMedias;
    private String perfilType; // 'Public' / 'Restricted'
    private boolean firstAccess;
    private boolean isPublic;
    private Trajectory trajectory;

    public Egress(String name, String email, String password, Date birthDate, Date startDate, Date endDate,
                  List<String> socialMedias, String perfilType) {
        super(name, email, password);
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.socialMedias = socialMedias;
        this.perfilType = perfilType;
        this.firstAccess = true;
        this.isPublic = true;
        this.trajectory = new Trajectory();
    }

        public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(List<String> socialMedias) {
        this.socialMedias = socialMedias;
    }

    public String getPerfilType() {
        return perfilType;
    }

    public void setPerfilType(String perfilType) {
        this.perfilType = perfilType;
    }
    
    public Trajectory getTrajectory() {
        return trajectory;
    }
    
    public void setTrajectory (Trajectory trajectory) {
        this.trajectory = trajectory;
    }

    public void createMilestone(String institution, String description, String role, Date startDate, Date finishDate, boolean current) {
        trajectory.addMilestone(institution, description, role, startDate, finishDate, current);
    }

    public void updateMilestone(String id, String institution, String description, String role, Date startDate, Date finishDate, boolean current) {
        trajectory.updateMilestone(id, institution, description, role, startDate, finishDate, current);
    }

    public void deleteMilestone(String id) {
        trajectory.deleteMilestone(id);
    }
}
