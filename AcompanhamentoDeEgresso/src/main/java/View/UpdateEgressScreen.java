package View;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.User;
import Model.UserSerializable;
import java.util.Date;
import java.util.List;

public class UpdateEgressScreen extends JFrame {
    private JTextField birthDateField;
    private JTextField startDateField;
    private JTextField endDateField;
    private JTextField socialMediaField;
    private JCheckBox visibilityCheckbox;
    private JButton updateButton;

    private UserSerializable userService;
    private List<User> users;

    public UpdateEgressScreen(List<User> users) {
        this.users = users;
        userService = new UserSerializable();

        setTitle("Update Egress");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel birthDateLabel = new JLabel("Data de nascimento:");
        birthDateLabel.setBounds(10, 20, 80, 25);
        panel.add(birthDateLabel);

        birthDateField = new JTextField();
        birthDateField.setBounds(100, 20, 165, 25);
        panel.add(birthDateField);

        JLabel startDateLabel = new JLabel("Data de inicio:");
        startDateLabel.setBounds(10, 50, 80, 25);
        panel.add(startDateLabel);

        startDateField = new JTextField();
        startDateField.setBounds(100, 50, 165, 25);
        panel.add(startDateField);

        JLabel endDateLabel = new JLabel("Data de termino:");
        endDateLabel.setBounds(10, 80, 80, 25);
        panel.add(endDateLabel);

        endDateField = new JTextField();
        endDateField.setBounds(100, 80, 165, 25);
        panel.add(endDateField);

        JLabel socialMediaLabel = new JLabel("Rede social:");
        socialMediaLabel.setBounds(10, 110, 100, 25);
        panel.add(socialMediaLabel);

        socialMediaField = new JTextField();
        socialMediaField.setBounds(100, 110, 165, 25);
        panel.add(socialMediaField);

        visibilityCheckbox = new JCheckBox("Perfil publico");
        visibilityCheckbox.setBounds(100, 140, 150, 25);
        panel.add(visibilityCheckbox);

        updateButton = new JButton("Atualizar Egresso");
        updateButton.setBounds(100, 180, 150, 25);
        panel.add(updateButton);

        add(panel);

        // Action listener for update button
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Date birthDate = new Date(birthDateField.getText());
                Date startDate = new Date(startDateField.getText());
                Date endDate = new Date(endDateField.getText());
                String[] socialMedia = socialMediaField.getText().split(",");
                boolean visibility = visibilityCheckbox.isSelected();

                userService.updateEgress(birthDate, startDate, endDate, socialMedia, visibility, users);
                JOptionPane.showMessageDialog(null, "Egresso atualizado com sucesso!");
            }
        });
    }
}
