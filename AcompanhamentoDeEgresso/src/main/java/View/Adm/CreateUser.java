/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Adm;

import Controller.SystemController;
import View.CustomComponents.RoundedBorder;
import java.awt.Color;
import javax.swing.JOptionPane;

public class CreateUser extends javax.swing.JPanel {

    /*
    * E -> Egress
    * U -> Common User
     */
    private char userType;

    /**
     * Creates new form NewEgress
     */
    public CreateUser(char userType) {
        initComponents();
        this.userType = userType;
        if (userType == 'E') {
            title.setText("NOVO EGRESSO");
        } else {
            title.setText("NOVO USUÁRIO");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(760, 266));

        jLabel1.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(36, 36, 36));
        jLabel1.setText("Nome");

        nameField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        nameField.setForeground(new java.awt.Color(36, 36, 36));
        nameField.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(36, 36, 36));
        jLabel2.setText("Email");

        emailField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        emailField.setForeground(new java.awt.Color(36, 36, 36));
        emailField.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jButton1.setBackground(new java.awt.Color(134, 241, 128));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Criar usuário");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(36, 36, 36));
        title.setText("Novo ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(226, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(title)
                        .addComponent(jLabel1)
                        .addComponent(nameField, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                        .addComponent(emailField)))
                .addContainerGap(252, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SystemController session = SystemController.getInstance();
        
        if (nameField.getText().isEmpty() || emailField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Campos em branco, preencha o nome e email",
            "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else if (session.emailExist(emailField.getText())){
            JOptionPane.showMessageDialog(null, "Email ja cadastrado",
            "Erro", JOptionPane.ERROR_MESSAGE);
        }
        else if (userType == 'U'){
            String password = session.createUser(nameField.getText(), emailField.getText(), 'U');
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso. A senha é: " + password, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } else if (userType == 'E'){
             String password = session.createEgress(nameField.getText(), emailField.getText(), 'E');
            JOptionPane.showMessageDialog(null, "Egresso cadastrado com sucesso. A senha é: " + password, "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nameField;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
