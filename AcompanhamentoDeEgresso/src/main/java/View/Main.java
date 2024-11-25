package View;

import View.Core.Home;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import Controller.Prototype;
import Model.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Prototype session = Prototype.getInstance();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("social_media1");
        session.createEgressFull("Billy", "billy@email.com", 'E',
                LocalDate.from(formatter.parse("05/06/1990")),
                LocalDate.from(formatter.parse("10/10/2010")),
                LocalDate.from(formatter.parse("11/11/2011")),
                list1,
                true);
        Trajectory traj = new Trajectory();
        traj.addMilestone("UNESP", "Passa eu Dr. Rogério", "Estudante de ciência da computação", LocalDate.now(), null, true);
        session.getEgresses().getFirst().setTrajectory(traj);
        session.createEgressFull("Adalberto", "adalberto@email.com", 'E',
                LocalDate.from(formatter.parse("12/12/2002")),
                LocalDate.from(formatter.parse("31/09/2023")),
                LocalDate.from(formatter.parse("01/05/2024")),
                list1,
                true);
        session.createEgressFull("Sonia", "sonia@email.com", 'E',
                LocalDate.from(formatter.parse("17/10/2000")),
                LocalDate.from(formatter.parse("15/02/2007")),
                LocalDate.from(formatter.parse("25/10/2013")),
                list1,
                true);
        
        JFrame frame = new Home();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
