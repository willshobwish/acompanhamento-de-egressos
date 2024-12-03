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
            LocalDate startDate,
            LocalDate endDate
    ) {
        super(name, email);
        this.startDate = startDate;
        this.endDate = endDate;
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

    public void addMilestone(Milestone newMilestone) {
        trajectory.addMilestone(newMilestone);
    }

    public void updateMilestone(Milestone oldMilestone, Milestone newMilestone) {
        trajectory.updateMilestone(oldMilestone, newMilestone);
    }

    public void deleteMilestone(Milestone milestone) {
        trajectory.deleteMilestone(milestone);
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

    public void updateData(String name, LocalDate birthDate, ArrayList<String> socialMedias, boolean publicProfile) {
        setName(name);
        setBirthDate(birthDate);
        setSocialMedias(socialMedias);
        setPublicProfile(publicProfile);
    }

    public void completeProfile(LocalDate birthDate, ArrayList<String> socialMedias, boolean publicProfile) {
        setBirthDate(birthDate);
        setSocialMedias(socialMedias);
        setPublicProfile(publicProfile);
        this.firstAccess = false;
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
