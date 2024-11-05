package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.User;
import Model.UserSerializable;
import java.util.List;

public class UserAddScreen extends JFrame {
    private JTextField nameField;
    private JTextField emailField;
    private JPasswordField passwordField;
    private JButton addButton;

    private UserSerializable userService;
    private List<User> users;

    public UserAddScreen(List<User> users) {
        this.users = users;
        userService = new UserSerializable();

        setTitle("Add User");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(10, 20, 80, 25);
        panel.add(nameLabel);

        nameField = new JTextField();
        nameField.setBounds(100, 20, 165, 25);
        panel.add(nameField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 50, 80, 25);
        panel.add(emailLabel);

        emailField = new JTextField();
        emailField.setBounds(100, 50, 165, 25);
        panel.add(emailField);

        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(10, 80, 80, 25);
        panel.add(passwordLabel);

        passwordField = new JPasswordField();
        passwordField.setBounds(100, 80, 165, 25);
        panel.add(passwordField);

        addButton = new JButton("Adicionar Usuario");
        addButton.setBounds(100, 120, 100, 25);
        panel.add(addButton);

        add(panel);

        // Action listener for add button
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String email = emailField.getText();
                String password = new String(passwordField.getPassword());

                User newUser = new User(name, email, password);
                userService.addUser(newUser, users);
                JOptionPane.showMessageDialog(null, "Usuario adicionado com sucesso!");
            }
        });
    }
}
