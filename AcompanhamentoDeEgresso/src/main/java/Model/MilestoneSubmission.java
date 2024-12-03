package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class PendentMilestone implements Serializable {
    private Egress egress;
    private Milestone oldMilestone;
    private Milestone newMilestone;
    private LocalDate createdAt;
    private String status;

    public PendentMilestone(Egress egress, Milestone newMilestone, Milestone oldMilestone, LocalDate createdAt, String status) {
        this.egress = egress;
        this.newMilestone = newMilestone;
        this.oldMilestone = oldMilestone;
        this.createdAt = createdAt;
        this.status = status;
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

    public Milestone getOldMilestone() {
        return oldMilestone;
    }

    public void setOldMilestone(Milestone oldMilestone) {
        this.oldMilestone = oldMilestone;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
