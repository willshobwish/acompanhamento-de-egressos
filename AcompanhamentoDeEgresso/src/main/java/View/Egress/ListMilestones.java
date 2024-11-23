/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Egress;

import Model.Milestone;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Karol
 */
public class ListMilestones extends javax.swing.JPanel {

    final private ArrayList<Milestone> milestones;
    final private boolean editable;

    /**
     * Creates new form MilestonesList
     *
     * @param milestones
     * @param editable
     */
    public ListMilestones(ArrayList<Milestone> milestones, boolean editable) {
        this.milestones = milestones;
        this.editable = editable;
        initComponents();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        initMilestones();
    }

    private void openModalMilestoneDetails(Milestone milestone) {
        MilestoneDetails modal = new MilestoneDetails(null, true, milestone);
        modal.setResizable(false);
        modal.setAlwaysOnTop(false);
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }

    private void handleDeleteMilestone(Milestone milestone) {
         int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar este marco?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            //controller.deleteMilestone(milestone.getId());
        }
        
        updateList();
    }

    private void openEditModal(Milestone milestone) {
        MilestoneForm form = new MilestoneForm(null, true, milestone);
        form.setResizable(false);
        form.setAlwaysOnTop(false);
        form.setLocationRelativeTo(null);
        form.setVisible(true);
        
        // avisar o usuário que após edição deve esperar o adm validar e pa
        // e que quando ele entrar no sistema os dados apareceram atualizados caso o 
        // adm tenha aprovado
    }

    private void updateList() {
        for (Component comp : content.getComponents()) {
            content.remove(comp);
        }
        content.revalidate();
        content.repaint();
        initMilestones();
        content.revalidate();
        content.repaint();
    }

    private void initMilestones() {

        milestones.forEach(milestone -> {

            JLabel labelRole = new JLabel(milestone.getRole());
            JLabel labelInstituition = new JLabel(milestone.getInstitution());
            JButton viewMoreButton = new JButton("Ver mais");
            JButton editButton = new JButton("Editar");
            JButton deleteButton = new JButton("Remover");

            Dimension buttonDimension = new Dimension(80, 24);

            viewMoreButton.addActionListener(e -> {
                this.openModalMilestoneDetails(milestone);
            });
            viewMoreButton.setBackground(Color.blue);
            viewMoreButton.setForeground(Color.white);
            viewMoreButton.setBorder(null);
            viewMoreButton.setMaximumSize(buttonDimension);
            viewMoreButton.setMinimumSize(buttonDimension);

            editButton.addActionListener(e -> {
                this.openEditModal(milestone);
            });
            editButton.setBackground(Color.orange);
            editButton.setForeground(Color.white);
            editButton.setBorder(null);
            editButton.setMaximumSize(buttonDimension);
            editButton.setMinimumSize(buttonDimension);

            deleteButton.addActionListener(e -> {
                this.handleDeleteMilestone(milestone);
            });
            deleteButton.setBackground(Color.red);
            deleteButton.setForeground(Color.white);
            deleteButton.setBorder(null);
            deleteButton.setMaximumSize(buttonDimension);
            deleteButton.setMinimumSize(buttonDimension);

            JPanel rowLayout = new JPanel();

            rowLayout.setLayout(new BoxLayout(rowLayout, BoxLayout.X_AXIS));
            rowLayout.add(labelInstituition);
            rowLayout.add(Box.createHorizontalStrut(16));
            rowLayout.add(labelRole);
            rowLayout.add(Box.createHorizontalStrut(16));
            if (!editable) {
                rowLayout.add(viewMoreButton);
                rowLayout.add(Box.createHorizontalStrut(16));
            }
            if (editable) {
                rowLayout.add(editButton);
                rowLayout.add(Box.createHorizontalStrut(16));
                rowLayout.add(deleteButton);
                rowLayout.add(Box.createHorizontalStrut(16));
            }

            content.add(rowLayout);
            content.add(Box.createVerticalStrut(5));
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JPanel();

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 298, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(content);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel content;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
