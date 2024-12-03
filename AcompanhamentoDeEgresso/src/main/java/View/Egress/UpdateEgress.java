/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Egress;

import Controller.SystemController;
import Interface.Callback;
import Model.Egress;
import View.CustomComponents.RoundedBorder;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UpdateEgress extends javax.swing.JPanel {

    private final Egress initialData;
    private final Callback onSuccess;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    SystemController session = SystemController.getInstance();

    /**
     * Creates new form UpdateEgress
     *
     * @param initialData
     */
    public UpdateEgress(Egress initialData, Callback onSuccess) {

        initialData = session.getEgressByEmail(session.getUserSession().getEmail());
        this.onSuccess = onSuccess;
        this.initialData = initialData;
        initComponents();
        initData();

        if (initialData.isFirstAccess()) {
            panel.remove(name);
            panel.remove(nameLabel);
        }
    }

    private void initData() {
        name.setText(initialData.getName());
        startDate.setText(initialData.getStartDate() != null
                ? initialData.getStartDate().format(formatter)
                : ""
        );
        endDate.setText(initialData.getEndDate() != null
                ? initialData.getEndDate().format(formatter)
                : ""
        );

        ArrayList<String> socialMedias = initialData.getSocialMedias();
        social1.setText(socialMedias.size() >= 1 ? socialMedias.get(0) : "");
        social2.setText(socialMedias.size() >= 2 ? socialMedias.get(1) : "");
        social3.setText(socialMedias.size() >= 3 ? socialMedias.get(2) : "");

        isPublic.setSelected(initialData.isPublic());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        social1 = new javax.swing.JTextField();
        social2 = new javax.swing.JTextField();
        social3 = new javax.swing.JTextField();
        isPublic = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        birth = new javax.swing.JFormattedTextField();
        startDate = new javax.swing.JFormattedTextField();
        endDate = new javax.swing.JFormattedTextField();

        panel.setBackground(new java.awt.Color(255, 255, 255));

        nameLabel.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(36, 36, 36));
        nameLabel.setText("Nome");

        name.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        name.setForeground(new java.awt.Color(36, 36, 36));
        name.setToolTipText("");
        name.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 36, 36));
        jLabel2.setText("Data ingresso");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(36, 36, 36));
        jLabel3.setText("Data de egresso");

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(36, 36, 36));
        jLabel4.setText("Redes sociais");

        social1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        social1.setForeground(new java.awt.Color(36, 36, 36));
        social1.setToolTipText("");
        social1.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        social1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                social1ActionPerformed(evt);
            }
        });

        social2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        social2.setForeground(new java.awt.Color(36, 36, 36));
        social2.setToolTipText("");
        social2.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        social3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        social3.setForeground(new java.awt.Color(36, 36, 36));
        social3.setToolTipText("");
        social3.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        isPublic.setBackground(new java.awt.Color(255, 255, 255));
        isPublic.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        isPublic.setForeground(new java.awt.Color(36, 36, 36));
        isPublic.setText("Perfil público");
        isPublic.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(51, 102, 255), 1, true));
        isPublic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isPublicActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(134, 241, 128));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Salvar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(36, 36, 36));
        jLabel5.setText("Datade nascimento");

        birth.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        birth.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        birth.setToolTipText("dd/MM/yyyy");

        startDate.setEditable(false);
        startDate.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        startDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        startDate.setToolTipText("dd/MM/yyyy");

        endDate.setEditable(false);
        endDate.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        endDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));
        endDate.setToolTipText("dd/MM/yyyy");

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(isPublic)
                            .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nameLabel, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                            .addComponent(social2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(social1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(social3, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(nameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel3))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(birth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(social1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(social2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(social3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(isPublic)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void isPublicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isPublicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isPublicActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        SystemController controller = SystemController.getInstance();

        ArrayList<String> socialMedias = new ArrayList<>();

        socialMedias.add(social1.getText());
        socialMedias.add(social2.getText());
        socialMedias.add(social3.getText());

        if (initialData.isFirstAccess()) {
            String message = controller.completeProfile(
                    LocalDate.parse(birth.getText(), formatter),
                    socialMedias,
                    isPublic.isSelected()
            );
            JOptionPane.showMessageDialog(null, message, "Operaçao finalizada", JOptionPane.INFORMATION_MESSAGE);

        } else {
            String message = controller.updateEgress(
                    name.getText(),
                    LocalDate.parse(birth.getText(), formatter),
                    socialMedias,
                    isPublic.isSelected()
            );
            JOptionPane.showMessageDialog(null, message, "Operaçao finalizada", JOptionPane.INFORMATION_MESSAGE);

        }

        onSuccess.execute();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void social1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_social1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_social1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField birth;
    private javax.swing.JFormattedTextField endDate;
    private javax.swing.JCheckBox isPublic;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField name;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField social1;
    private javax.swing.JTextField social2;
    private javax.swing.JTextField social3;
    private javax.swing.JFormattedTextField startDate;
    // End of variables declaration//GEN-END:variables
}
