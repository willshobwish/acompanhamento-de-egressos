/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Egress;

import Model.Egress;
import Model.Trajectory;
import java.awt.Color;
import java.awt.Dimension;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Karol
 */
public class ListEgress extends javax.swing.JPanel {
    private final boolean hasAccess;

    /**
     * Creates new form ListEgress
     * @param hasAccess
     */
    public ListEgress(boolean hasAccess) {
        initComponents();
        this.hasAccess = hasAccess;
        scrollPanelEgress.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        dataPanel.setLayout(new BoxLayout(dataPanel, BoxLayout.Y_AXIS));
        initEgressList();
    }

    private void initEgressList() {
        //ArrayList<Egress> egress = this.hasAccess ? controller.getAllEgress() : controller.getPublicEgress();
        ArrayList<Egress> egressList = new ArrayList<>();

        // to test
        egressList.add(new Egress("karolyne domiciano marques", 
                "karolyne.d.marques@unesp.br", 
                "", 
                LocalDate.now(), 
                LocalDate.now(), 
                LocalDate.now(), 
                new ArrayList<>(Arrays.asList("https://linkedin.com/in/karoldm")), 
                true
        ));
        egressList.getFirst().setFirstAccess(false);
        Trajectory traj = new Trajectory();
        traj.addMilestone("UNESP", "aprendendendo e se fodendo", "Estudante de ciência da computação", LocalDate.now(), null, true);
        egressList.getFirst().setTrajectory(traj);
        egressList.forEach(egress -> {
            if (egress.isFirstAccess()) {
                return;
            }

            JLabel labelName = new JLabel(egress.getName());
            JTextField labelEmail = new JTextField(egress.getEmail());
            labelEmail.setEditable(false);
            labelEmail.setMaximumSize(new Dimension(200, 24));
            JButton buttonViewDetails = new JButton("Ver dados");

            JPanel rowLayout = new JPanel();
            //rowLayout.setBackground(Color.white);
            Dimension buttonDimension = new Dimension(80, 24);

            buttonViewDetails.addActionListener(e -> {
                this.openModalDetails(egress);
            });
            buttonViewDetails.setBackground(Color.blue);
            buttonViewDetails.setForeground(Color.white);
            buttonViewDetails.setBorder(null);
            buttonViewDetails.setMaximumSize(buttonDimension);
            buttonViewDetails.setMinimumSize(buttonDimension);

            rowLayout.setLayout(new BoxLayout(rowLayout, BoxLayout.X_AXIS));
            rowLayout.add(labelName);
            rowLayout.add(Box.createHorizontalStrut(24));
            rowLayout.add(labelEmail);
            rowLayout.add(Box.createHorizontalStrut(24));
            rowLayout.add(buttonViewDetails);
            rowLayout.add(Box.createHorizontalStrut(24));

            dataPanel.add(rowLayout);
            dataPanel.add(Box.createVerticalStrut(5));
        });

        scrollPanelEgress.setViewportView(dataPanel);
    }

    private void openModalDetails(Egress egress) {
        EgressDetails modal = new EgressDetails(null, true, egress);
        modal.setResizable(false);
        modal.setAlwaysOnTop(false);
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanelEgress = new javax.swing.JScrollPane();
        dataPanel = new javax.swing.JPanel();

        setMaximumSize(new java.awt.Dimension(610, 328));
        setMinimumSize(new java.awt.Dimension(610, 328));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(610, 328));

        scrollPanelEgress.setMaximumSize(new java.awt.Dimension(610, 328));
        scrollPanelEgress.setMinimumSize(new java.awt.Dimension(610, 328));

        javax.swing.GroupLayout dataPanelLayout = new javax.swing.GroupLayout(dataPanel);
        dataPanel.setLayout(dataPanelLayout);
        dataPanelLayout.setHorizontalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 608, Short.MAX_VALUE)
        );
        dataPanelLayout.setVerticalGroup(
            dataPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 326, Short.MAX_VALUE)
        );

        scrollPanelEgress.setViewportView(dataPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelEgress, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scrollPanelEgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel dataPanel;
    private javax.swing.JScrollPane scrollPanelEgress;
    // End of variables declaration//GEN-END:variables
}
