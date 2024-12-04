/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.Egress;

import Model.Egress;
import Model.Milestone;
import View.CustomComponents.RoundedBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Karol
 */
public class ListTrajectoryModal extends javax.swing.JDialog {

    /**
     * Creates new form ListTrajectoryModal
     */
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DefaultTableModel tableModel;
    private final Egress egress;

    /**
     * Creates new form Trajectory
     *
     * @param parent
     * @param modal
     * @param egress
     */
    public ListTrajectoryModal(java.awt.Frame parent, boolean modal, Egress egress) {
        initComponents();
        this.egress = egress;
        this.tableModel = (DefaultTableModel) dataTable.getModel();
        this.scrollTable.getViewport().setBackground(Color.WHITE);

        initTable();
        populateTable(egress.getTrajectory().getMilestones());

        title.setText(egress.getName() + " de " + egress.getStartDate().format(formatter) + " à " + egress.getEndDate().format(formatter));
        countLabel.setText(egress.getTrajectory().getMilestones().size() + " marcos encontrados");
    }

    private void initTable() {

        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(new Color(255, 255, 255));
        headerRenderer.setForeground(new Color(36, 36, 36));
        headerRenderer.setPreferredSize(new Dimension(450, 32));
        headerRenderer.setBorder(BorderFactory.createLineBorder(new Color(193, 193, 193)));
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        JTableHeader header = dataTable.getTableHeader();
        header.setDefaultRenderer(headerRenderer);

        dataTable.getColumnModel().getColumn(4).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel.setBackground(Color.WHITE);
            JButton button = new JButton(value.toString());;
//            JButton button = new JButton("Ver detalhes");
            button.setBackground(new Color(146, 214, 243));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setPreferredSize(new Dimension(100, 20));
            button.setBorder(BorderFactory.createEmptyBorder());
            panel.add(button);
            return panel;
        });

        for (int i = 1; i < dataTable.getColumnCount() - 1; i++) {
            dataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }

    }

    private void clearTable() {
        for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {
            this.tableModel.removeRow(i);
        }
    }

    private void populateTable(ArrayList<Milestone> milestones) {
        countLabel.setText(milestones.size() + " marcos encontrados");

        milestones.forEach(milestone -> {

            ArrayList<Object> rowData = new ArrayList<>();

            rowData.add(milestone.getInstitution());
            rowData.add(milestone.getRole());
            rowData.add(milestone.getStartDate().format(formatter));
            if (milestone.getFinishDate() != null) {
                rowData.add(milestone.getFinishDate().format(formatter));
            } else {
                rowData.add("Atualmente");
            }
            rowData.add("Ver detalhes");

            this.tableModel.addRow(rowData.toArray());
        });

        for (java.awt.event.MouseListener listener : dataTable.getMouseListeners()) {
            dataTable.removeMouseListener(listener);
        }

        dataTable.addMouseListener(
                new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt
            ) {
                int row = dataTable.rowAtPoint(evt.getPoint());
                int col = dataTable.columnAtPoint(evt.getPoint());
                if (row >= 0) {
                    if (col == 4) {
                        openModalDescription(milestones.get(row));
                    }

                }
            }
        });
    }

    private void openModalDescription(Milestone milestone) {
        DescriptionModal modal = new DescriptionModal(null, false, milestone.getDescription());
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

        jPanel1 = new javax.swing.JPanel();
        scrollTable = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        countLabel = new javax.swing.JLabel();
        filterField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));

        dataTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        dataTable.setForeground(new java.awt.Color(36, 36, 36));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instituição", "Função", "Ínicio", "Término", "Descrição"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dataTable.setGridColor(new java.awt.Color(255, 255, 255));
        dataTable.setRowHeight(40);
        dataTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        dataTable.setSelectionForeground(new java.awt.Color(36, 36, 36));
        scrollTable.setViewportView(dataTable);

        countLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        countLabel.setForeground(new java.awt.Color(36, 36, 36));
        countLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        countLabel.setText("Encontrados 45");

        filterField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        filterField.setForeground(new java.awt.Color(36, 36, 36));
        filterField.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        filterButton.setBackground(new java.awt.Color(193, 193, 193));
        filterButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        filterButton.setForeground(new java.awt.Color(255, 255, 255));
        filterButton.setText("Filtrar");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        title.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        title.setForeground(new java.awt.Color(36, 36, 36));
        title.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterButton)))
                        .addContainerGap(339, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLabel)
                    .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        clearTable();
        ArrayList<Milestone> filtered = new ArrayList<>();
        String filter = filterField.getText();

        for (Milestone milestone : egress.getTrajectory().getMilestones()) {
            if (milestone.getInstitution().contains(filter)
                    || milestone.getRole().contains(filter)
                    || milestone.getDescription().contains(filter)
                    || milestone.getStartDate().format(formatter).contains(filter)
                    || milestone.getFinishDate().format(formatter).contains(filter)) {
                filtered.add(milestone);
            }
        }
        populateTable(filtered);
    }//GEN-LAST:event_filterButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ListTrajectoryModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListTrajectoryModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListTrajectoryModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListTrajectoryModal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ListTrajectoryModal dialog = new ListTrajectoryModal(new javax.swing.JFrame(), true, null);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countLabel;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton filterButton;
    private javax.swing.JTextField filterField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
