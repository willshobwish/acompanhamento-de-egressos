package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Logger;

public class Administrator extends User {
    
    private ArrayList<PendentMilestone> pendentMilestones;
    private static final Logger logger = Logger.getLogger(Administrator.class.getName());

    public Administrator() {
        super("admin", "admin");
        this.setPassword("admin");
        this.pendentMilestones = new ArrayList<>();
    }

    public ArrayList<PendentMilestone> getPendentMilestones() {
        return pendentMilestones;
    }

    public void setPendentMilestones(ArrayList<PendentMilestone> pendentMilestones) {
        this.pendentMilestones = pendentMilestones;
    }
    
    public void createPendentMilestone(Milestone oldMilestone, Milestone newMilestone, Egress egress) {
        PendentMilestone pendentMilestone = new PendentMilestone(egress, newMilestone, oldMilestone, LocalDate.now(), "Pendente");
        addPendentMilestone(pendentMilestone);
    }
    
    public void addPendentMilestone(PendentMilestone pendentMilestone){
        this.pendentMilestones.add(pendentMilestone);
    }

    // Method to validate a milestone
    public void validateMilestone(PendentMilestone pendentMilestone, boolean approved) {
        if (pendentMilestone == null) {
            logger.info("Error: PendentMilestone is null.");
            return;
        }

        Egress egress = pendentMilestone.getEgress();
        Milestone milestone = pendentMilestone.getNewMilestone();

        if (egress == null || milestone == null) {
            logger.info("Error: Egress or Milestone is missing.");
            return;
        }

        if (approved) {
            // aqui precisa substituir a milestone usando o id de pendentMilestone.getOldMilestone() e não criar uma nova
            egress.getTrajectory().addMilestone(
                    milestone.getInstitution(),
                    milestone.getDescription(),
                    milestone.getRole(),
                    milestone.getStartDate(),
                    milestone.getFinishDate(),
                    milestone.isCurrent()
            );
            logger.info("Milestone approved and added to egress: " + egress.getName());
        } else {
            logger.info("Milestone rejected for egress: " + egress.getName());
        }
        pendentMilestones.remove(pendentMilestone);
    }
}
