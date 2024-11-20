package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class Trajectory {
    private List<Milestone> milestones;

    // Constructor
    public Trajectory() {
        this.milestones = new ArrayList<>();
    }

    // Get all milestones
    public List<Milestone> getMilestones() {
        return milestones;
    }

    // Set milestones
    public void setMilestones(List<Milestone> milestones) {
        if (milestones == null) {
            throw new IllegalArgumentException("Milestones list cannot be null.");
        }
        this.milestones = milestones;
    }

    // Add a new milestone
    public void addMilestone(String institution, String description, String role, 
                             Date startDate, Date finishDate, boolean current) {
        Milestone newMilestone = new Milestone(institution, description, role, startDate, finishDate, current);
        milestones.add(newMilestone);
        System.out.println("Milestone added successfully: " + institution);
    }

    // Update an existing milestone by ID
    public void updateMilestone(String id, String institution, String description, String role, 
                                Date startDate, Date finishDate, boolean current) {
        for (Milestone milestone : milestones) {
            if (milestone.getId().equals(id)) {
                milestone.setInstitution(institution);
                milestone.setDescription(description);
                milestone.setRole(role);
                milestone.setStartDate(startDate);
                milestone.setFinishDate(finishDate);
                milestone.setCurrent(current);
                System.out.println("Milestone updated successfully: " + institution);
                return;
            }
        }
        System.out.println("Milestone with ID " + id + " not found.");
    }

    // Delete a milestone by ID
    public void deleteMilestone(String id) {
        milestones.removeIf(milestone -> milestone.getId().equals(id));
        System.out.println("Milestone with ID " + id + " deleted successfully.");
    }

    // Set a specific milestone directly
    public void setMilestone(Milestone newMilestone) {
        if (newMilestone == null) {
            System.out.println("Error: Cannot set a null milestone.");
            return;
        }
        for (int i = 0; i < milestones.size(); i++) {
            if (milestones.get(i).getId().equals(newMilestone.getId())) {
                milestones.set(i, newMilestone);
                System.out.println("Milestone updated directly: " + newMilestone.getInstitution());
                return;
            }
        }
        milestones.add(newMilestone);
        System.out.println("New milestone added directly: " + newMilestone.getInstitution());
    }
}
