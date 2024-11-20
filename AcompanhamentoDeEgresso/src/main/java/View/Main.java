package View;

import Model.*;
import Model.Egress;
import Model.Milestone;
import Model.Trajectory;
import Model.UserSerializable;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // inicializar UserSerializable e Trajectory
        UserSerializable userSerializable = new UserSerializable();
        Trajectory trajectory = new Trajectory();

        // teste criação de usuario
        System.out.println("=== Criacao de Usuario ===");
        userSerializable.createUser("Admin", "admin@exemplo.com", 'A');
        userSerializable.createUser("Bob", "bob@exemplo.com", 'E');
        userSerializable.createUser("Admin", "admin@exemplo.com", 'E'); // email duplicado

        // teste Login
        System.out.println("\n=== Login ===");
        userSerializable.login("admin@exemplo.com", "wrongpassword"); // senha errada
        userSerializable.login("admin@exemplo.com", "admin");  // login certo

        // teste gerenciamento de egresso
        System.out.println("\n=== Gerenciamento de Egresso ===");
        Egress egress = new Egress(
            "Alice", 
            "alice@exemplo.com", 
            "senha123", 
            new Date(1990, 1, 1), 
            new Date(2010, 8, 15), 
            new Date(2014, 5, 30), 
            List.of("LinkedIn", "GitHub"), 
            "public"
        );
        userSerializable.saveEgress(egress);

        userSerializable.updateEgress(
            new Date(1990, 1, 2), 
            new Date(2010, 8, 16), 
            new Date(2014, 5, 31), 
            List.of("LinkedIn", "Twitter"), 
            true
        );

        // teste Milestone
        System.out.println("\n=== Gerenciamento de Milestone ===");
        trajectory.addMilestone("Unesp", "Graduação", "Estudante", new Date(2010, 8, 15), new Date(2014, 5, 30), false);
        trajectory.addMilestone("Nasa", "Estagio", "Estagiario", new Date(2015, 1, 1), new Date(2016, 12, 31), false);

        // listar milestones
        System.out.println("\n--- Milestones ---");
        for (Milestone milestone : trajectory.getMilestones()) {
            System.out.println("Instituicao: " + milestone.getInstitution() + ", Funcao: " + milestone.getRole());
        }

        // update milestone
        Milestone milestoneToUpdate = trajectory.getMilestones().get(0);
        trajectory.updateMilestone(
            milestoneToUpdate.getId(), 
            "Unesp", 
            "Graduado", 
            "Graduado", 
            new Date(2010, 8, 15), 
            new Date(2014, 5, 30), 
            false
        );

        // Deletar milestone
        Milestone milestoneToDelete = trajectory.getMilestones().get(1);
        trajectory.deleteMilestone(milestoneToDelete.getId());

        // lista milestones depois do update e delete
        System.out.println("\n--- Milestones Depois do Update/Delete ---");
        for (Milestone milestone : trajectory.getMilestones()) {
            System.out.println("Instituicao: " + milestone.getInstitution() + ", Funcao: " + milestone.getRole());
        }

        // Teste Administrator Validation
        System.out.println("\n=== Validacao de Administrador ===");
        Administrator admin = new Administrator("Admin", "admin@exemplo.com", "admin123");
        Milestone pendingMilestone = new Milestone("Valve", "Software Developer", "Developer", new Date(), new Date(), false);
        PendentMilestone pendentMilestone = new PendentMilestone(egress, pendingMilestone);
        admin.validateMilestone(pendentMilestone, true); // Aprovar milestone
        
        // Listar milestones pendentes
        System.out.println("\n--- Milestones Pendentes ---");
        List<Milestone> pendingMilestones = userSerializable.listPendentsMilestones();
        for (Milestone pending : pendingMilestones) {
            System.out.println("Instituicao: " + pending.getInstitution() + ", Funcao: " + pending.getRole());
        }
    }
}
