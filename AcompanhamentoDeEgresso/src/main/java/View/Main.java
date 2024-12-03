package View;

import View.Core.Home;
import javax.swing.JFrame;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class Main {

    public static void main(String[] args) {
        
        JFrame frame = new Home();
        frame.setResizable(false);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setAlwaysOnTop(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
