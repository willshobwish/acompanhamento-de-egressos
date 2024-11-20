package Model;

import java.util.ArrayList;
import java.util.List;

public class Administrator extends User {
    private List<PendentMilestone> pendentMilestones;

    // Constructor
    public Administrator(String name, String email, String password) {
        super(name, email, password);
        this.pendentMilestones = new ArrayList<>();
    }

    // Getters and Setters
    public List<PendentMilestone> getPendentMilestones() {
        return pendentMilestones;
    }

    public void setPendentMilestones(List<PendentMilestone> pendentMilestones) {
        this.pendentMilestones = pendentMilestones;
    }

    // Method to validate a milestone
    public void validateMilestone(PendentMilestone pendentMilestone, boolean approved) {
        if (pendentMilestone == null) {
            System.out.println("Error: PendentMilestone is null.");
            return;
        }

        Egress egress = pendentMilestone.getEgress();
        Milestone milestone = pendentMilestone.getNewMilestone();

        if (egress == null || milestone == null) {
            System.out.println("Error: Egress or Milestone is missing.");
            return;
        }

        if (approved) {
            egress.getTrajectory().addMilestone(
                milestone.getInstitution(),
                milestone.getDescription(),
                milestone.getRole(),
                milestone.getStartDate(),
                milestone.getFinishDate(),
                milestone.isCurrent()
            );
            System.out.println("Milestone approved and added to egress: " + egress.getName());
        } else {
            System.out.println("Milestone rejected for egress: " + egress.getName());
        }

        // Remove the validated milestone from the pending list
        pendentMilestones.remove(pendentMilestone);
    }
}
