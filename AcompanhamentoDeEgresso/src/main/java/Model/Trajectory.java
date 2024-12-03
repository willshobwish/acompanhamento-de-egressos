package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Trajectory implements Serializable{
    private final ArrayList<Milestone> milestones;

    // Constructor
    public Trajectory() {
        this.milestones = new ArrayList<>();
    }

    // Get all milestones
    public ArrayList<Milestone> getMilestones() {
        return milestones;
    }


    public void addMilestone(Milestone newMilestone) {
        milestones.add(newMilestone);
    }

    public void updateMilestone(Milestone oldMilestone, Milestone newMilestone) {
        for (Milestone milestone : milestones) {
            if (milestone.getId().equals(newMilestone.getId())) {
                milestone.setInstitution(newMilestone.getInstitution());
                milestone.setDescription(newMilestone.getDescription());
                milestone.setRole(newMilestone.getRole());
                milestone.setStartDate(newMilestone.getStartDate());
                milestone.setFinishDate(newMilestone.getFinishDate());
                milestone.setCurrent(newMilestone.isCurrent());
                return;
            }
        }
    }

    public void deleteMilestone(Milestone milestone) {
        milestones.removeIf(milestoneList -> milestoneList.getId().equals(milestone.getId()));
    }
}
