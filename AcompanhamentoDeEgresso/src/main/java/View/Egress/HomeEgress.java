/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Egress;

import View.Egress.UpdateEgress;
import Model.Egress;
import Model.Trajectory;
import View.Core.UpdatePassword;
import java.awt.BorderLayout;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JPanel;

/**
 *
 * @author Karol
 */
public class HomeEgress extends javax.swing.JFrame {

    private Egress userSession;

    /**
     * Creates new form HomeEgress
     */
    public HomeEgress() {
        initComponents();

        // to test
        userSession = new Egress("karolyne domiciano marques",
                "karolyne.d.marques@unesp.br",
                "",
                LocalDate.now(),
                LocalDate.now(),
                LocalDate.now(),
                new ArrayList<>(Arrays.asList("https://linkedin.com/in/karoldm")),
                true
        );
        Trajectory traj = new Trajectory();
        traj.addMilestone("UNESP", "aprendendendo e se fodendo", "Estudante de ciência da computação", LocalDate.now(), null, true);
        ((Egress) userSession).setTrajectory(traj);

        if (userSession.isFirstAccess()) {
            UpdateEgress form = new UpdateEgress(userSession, () -> {
                this.menuAccount.setEnabled(true);
                this.menuEgress.setEnabled(true);
                this.menuTrajectory.setEnabled(true);
                ListEgress formEgress = new ListEgress(true);
                showForm(formEgress);
            });
            showForm(form);
            this.menuAccount.setEnabled(false);
            this.menuEgress.setEnabled(false);
            this.menuTrajectory.setEnabled(false);
        } else {
            ListEgress form = new ListEgress(true);
            showForm(form);
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

        content = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuEgress = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuAccount = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        menuTrajectory = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        content.setBackground(new java.awt.Color(255, 255, 255));
        content.setMaximumSize(new java.awt.Dimension(610, 328));
        content.setMinimumSize(new java.awt.Dimension(610, 328));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
        );

        menuEgress.setText("Egressos");

        jMenuItem4.setText("Listar egressos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        menuEgress.add(jMenuItem4);

        jMenuBar1.add(menuEgress);

        menuAccount.setText("Minha conta");

        jMenuItem3.setText("Atualizar senha");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        menuAccount.add(jMenuItem3);

        jMenuItem2.setText("Editar dados da conta");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        menuAccount.add(jMenuItem2);

        jMenuBar1.add(menuAccount);

        menuTrajectory.setText("Trajetória");

        jMenuItem1.setText("Adicionar marco");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menuTrajectory.add(jMenuItem1);

        jMenuItem6.setText("Listar marcos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        menuTrajectory.add(jMenuItem6);

        jMenuBar1.add(menuTrajectory);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showForm(JPanel form) {
        content.removeAll();

        content.setLayout(new BorderLayout());
        content.add(form, BorderLayout.CENTER);

        content.revalidate();
        content.repaint();
    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        ListEgress form = new ListEgress(true);
        showForm(form);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        UpdatePassword form = new UpdatePassword();
        showForm(form);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        UpdateEgress form = new UpdateEgress(userSession, null);
        showForm(form);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        ListMilestones form = new ListMilestones(userSession.getTrajectory().getMilestones(), true);
        showForm(form);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MilestoneForm form = new MilestoneForm(null, true, null);
        form.setResizable(false);
        form.setAlwaysOnTop(false);
        form.setLocationRelativeTo(null);
        form.setVisible(true);

        // avisar o usuário que após edição deve esperar o adm validar e pa
        // e que quando ele entrar no sistema os dados apareceram atualizados caso o 
        // adm tenha aprovado
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeEgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeEgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeEgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeEgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeEgress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenu menuAccount;
    private javax.swing.JMenu menuEgress;
    private javax.swing.JMenu menuTrajectory;
    // End of variables declaration//GEN-END:variables
}
