package View;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class MainFrame extends JFrame {
    public void init() {
        setSize(450, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // Create and display the createEgress frame
        createEgress egressFrame = new createEgress();
        egressFrame.setVisible(true);  // Show the createEgress window
    }
}
