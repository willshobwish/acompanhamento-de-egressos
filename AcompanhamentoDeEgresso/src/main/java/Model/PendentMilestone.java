package Model;

import java.io.Serializable;

public class PendentMilestone implements Serializable {
    private Egress egress;
    private Milestone newMilestone;

    public PendentMilestone(Egress egress, Milestone newMilestone) {
        this.egress = egress;
        this.newMilestone = newMilestone;
    }

    public Egress getEgress() {
        return egress;
    }

    public void setEgress(Egress egress) {
        this.egress = egress;
    }

    public Milestone getNewMilestone() {
        return newMilestone;
    }

    public void setNewMilestone(Milestone newMilestone) {
        this.newMilestone = newMilestone;
    }

    // Utility methods (Optional)
    @Override
    public String toString() {
        return "PendentMilestone{" +
                "egress=" + (egress != null ? egress.getName() : "null") +
                ", newMilestone=" + (newMilestone != null ? newMilestone.getDescription() : "null") +
                '}';
    }
}
