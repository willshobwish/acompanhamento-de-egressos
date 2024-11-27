package Model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Egress extends User {

    private LocalDate birthDate;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<String> socialMedias;
    private boolean firstAccess;
    private boolean publicProfile;
    private Trajectory trajectory;

    public Egress(
            String name, 
            String email, 
            String password, 
            LocalDate birthDate, 
            LocalDate startDate, 
            LocalDate endDate, 
            ArrayList<String> socialMedias, 
            boolean isPublic
    ) {
        super(name, email, password);
        this.birthDate = birthDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.socialMedias = socialMedias;
        this.publicProfile = isPublic;
        this.firstAccess = true;
        this.trajectory = new Trajectory();
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public ArrayList<String> getSocialMedias() {
        return socialMedias;
    }

    public void setSocialMedias(ArrayList<String> socialMedias) {
        this.socialMedias = socialMedias;
    }

    public Trajectory getTrajectory() {
        return trajectory;
    }

    public void setTrajectory(Trajectory trajectory) {
        this.trajectory = trajectory;
    }

    public void createMilestone(String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        trajectory.addMilestone(institution, description, role, startDate, finishDate, current);
    }

    public void updateMilestone(String id, String institution, String description, String role, LocalDate startDate, LocalDate finishDate, boolean current) {
        trajectory.updateMilestone(id, institution, description, role, startDate, finishDate, current);
    }

    public void deleteMilestone(String id) {
        trajectory.deleteMilestone(id);
    }

    public boolean isPublic() {
        return publicProfile;
    }

    public void setPublicProfile(boolean publicProfile) {
        this.publicProfile = publicProfile;
    }

    public boolean isFirstAccess() {
        return firstAccess;
    }

    public void setFirstAccess(boolean firstAccess) {
        this.firstAccess = firstAccess;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
//        StringBuilder sb = new StringBuilder();;
        sb.append("Egress\n");
        sb.append("birthDate=").append(birthDate);
        sb.append("\nstartDate=").append(startDate);
        sb.append("\nendDate=").append(endDate);
        sb.append("\nsocialMedias=").append(socialMedias);
        sb.append("\nfirstAccess=").append(firstAccess);
        sb.append("\npublicProfile=").append(publicProfile);
        sb.append("\ntrajectory=").append(trajectory);
        sb.append("\n\n");
        return sb.toString();
    }

}
