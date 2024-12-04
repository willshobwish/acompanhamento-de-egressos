/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Egress;

import Controller.SystemController;
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
public class ListMilestonesEditable extends javax.swing.JPanel {

    private final Egress egress;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DefaultTableModel tableModel;
    private final SystemController controller = SystemController.getInstance();

    /**
     * Creates new form ListMilestones
     *
     * @param egress
     */
    public ListMilestonesEditable(Egress egress) {
        this.egress = egress;
        initComponents();
        this.tableModel = (DefaultTableModel) dataTable.getModel();
        this.scrollTable.getViewport().setBackground(Color.WHITE);

        initTable();
        populateTable(egress.getTrajectory().getMilestones());

        title.setText(egress.getName() + " de " + egress.getStartDate().format(formatter) + " à " + egress.getEndDate().format(formatter));
        countLabel.setText(egress.getTrajectory().getMilestones().size() + " marcos encontrados");
    }

    private void populateTable(ArrayList<Milestone> milestones) {
        countLabel.setText(milestones.size() + " marcos encontrados");

        milestones.forEach(milestone -> {

            ArrayList<Object> rowData = new ArrayList<>();

            rowData.add(milestone.getInstitution());
            rowData.add(milestone.getRole());
            rowData.add(milestone.getStartDate().format(formatter));
            rowData.add(milestone.getFinishDate().format(formatter));
            rowData.add("Ver detalhes");
            rowData.add("Editar");

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
                    } else if (col == 5) {
                        openModalEdit(milestones.get(row));
                    }

                }
            }
        });

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
            JButton button = new JButton(value.toString());
            button.setBackground(new Color(146, 214, 243));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setPreferredSize(new Dimension(100, 20));
            button.setBorder(BorderFactory.createEmptyBorder());
            panel.add(button);
            return panel;
        });

        dataTable.getColumnModel().getColumn(5).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel.setBackground(Color.WHITE);
            JButton button = new JButton(value.toString());
            button.setBackground(new Color(146, 214, 243));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setPreferredSize(new Dimension(100, 20));
            button.setBorder(BorderFactory.createEmptyBorder());
            panel.add(button);
            return panel;
        });

        for (int i = 1; i < dataTable.getColumnCount() - 2; i++) {
            dataTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }

    private void clearTable() {
        for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {
            this.tableModel.removeRow(i);
        }
    }

    private void openModalDescription(Milestone milestone) {
        DescriptionModal modal = new DescriptionModal(null, false, milestone.getDescription());
        modal.setResizable(false);
        modal.setAlwaysOnTop(false);
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }

    private void openModalEdit(Milestone milestone) {
        MilestoneForm modal = new MilestoneForm(null, false, milestone);
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

        scrollTable = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        countLabel = new javax.swing.JLabel();
        filterField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        title = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));

        dataTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        dataTable.setForeground(new java.awt.Color(36, 36, 36));
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Instituição", "Função", "Ínicio", "Término", "Descrição", "Ações"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true
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
        countLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterButton)))
                        .addContainerGap(340, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scrollTable, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(title)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(countLabel, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(scrollTable, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        clearTable();
        ArrayList<Milestone> filtered = new ArrayList<>();
        String filter = filterField.getText();

        for (Milestone milestone : egress.getTrajectory().getMilestones()) {
            if (milestone.getRole().contains(filter)
                    || milestone.getInstitution().contains(filter)
                    || milestone.getDescription().contains(filter)
                    || milestone.getStartDate().format(formatter).contains(filter)
                    || milestone.getFinishDate().format(formatter).contains(filter)) {
                filtered.add(milestone);
            }
        }
        populateTable(filtered);
    }//GEN-LAST:event_filterButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel countLabel;
    private javax.swing.JTable dataTable;
    private javax.swing.JButton filterButton;
    private javax.swing.JTextField filterField;
    private javax.swing.JScrollPane scrollTable;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
