package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.UserSerializable;
import java.util.List;
import Model.User;

public class LoginScreen extends JFrame {
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private UserSerializable userService;

    public LoginScreen(List<User> users) {
        userService = new UserSerializable();
        
        setTitle("Login");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Layout setup
        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 20, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 20, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 50, 165, 25);
        panel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBounds(100, 80, 80, 25);
        panel.add(loginButton);

        add(panel);

        // Event handler for login
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                if (userService.login(email, password, users)) {
                    JOptionPane.showMessageDialog(null, "Login realizado com sucesso!");
                    new UserAddScreen(users).setVisible(true);
                    dispose();  // Close the login screen
                } else {
                    JOptionPane.showMessageDialog(null, "Email ou senha invalidos.");
                }
            }
        });
    }
}
