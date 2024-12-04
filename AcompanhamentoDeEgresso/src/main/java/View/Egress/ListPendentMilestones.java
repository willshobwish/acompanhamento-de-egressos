/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Egress;

import Controller.SystemController;
import Model.Milestone;
import Model.MilestoneSubmission;
import View.Adm.MilestonePendentModifications;
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
public class ListPendentMilestones extends javax.swing.JPanel {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final DefaultTableModel tableModel;
    private final SystemController controller = SystemController.getInstance();

    /**
     * Creates new form PendentMilestones
     */
    public ListPendentMilestones() {
        initComponents();
        this.tableModel = (DefaultTableModel) dataTable.getModel();
        initPendentList();
        populateTable(controller.listPendentsMilestonesByEgress());
    }

    private void initPendentList() {
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

        dataTable.getColumnModel().getColumn(1).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
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

        dataTable.getColumnModel().getColumn(2).setCellRenderer((table, value, isSelected, hasFocus, row, column) -> {
            JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            panel.setBackground(Color.WHITE);
            JButton button = new JButton(value.toString());
            button.setBackground(getBackgroundByStatus(value.toString()));
            button.setForeground(Color.WHITE);
            button.setFocusPainted(false);
            button.setPreferredSize(new Dimension(100, 20));
            button.setBorder(BorderFactory.createEmptyBorder());
            panel.add(button);
            return panel;
        });

        dataTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

    }

    private void populateTable(ArrayList<MilestoneSubmission> pendentList) {
        countLabel.setText(pendentList.size() + " atualizações encontradas");
        
        pendentList.forEach(milestone -> {

            ArrayList<Object> rowData = new ArrayList<>();

            rowData.add(milestone.getCreatedAt().format(formatter));
            rowData.add("Ver modificações");
            rowData.add(milestone.getStatus());

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
                    if (col == 1) {
                        openModifications(pendentList.get(row));
                    }
                }
            }
        });
    }

    private Color getBackgroundByStatus(String status) {
        switch (status) {
            case "Pendente":
                return new Color(227, 132, 0);
            case "Aprovado":
                return new Color(134, 241, 128);
            case "Recusado":
            default:
                return new Color(243, 111, 111);
        }
    }

    private void openModifications(MilestoneSubmission pendentMilestone) {
        MilestonePendentModifications modal = new MilestonePendentModifications(null, false, pendentMilestone, null);
        modal.setResizable(false);
        modal.setAlwaysOnTop(false);
        modal.setLocationRelativeTo(null);
        modal.setVisible(true);
    }

    private void clearTable() {
        for (int i = this.tableModel.getRowCount() - 1; i >= 0; i--) {
            this.tableModel.removeRow(i);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        dataTable = new javax.swing.JTable();
        countLabel = new javax.swing.JLabel();
        filterField = new javax.swing.JTextField();
        filterButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(252, 252, 252));

        dataTable.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        dataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Data da modificação", "Modificações", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
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
        jScrollPane1.setViewportView(dataTable);

        countLabel.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        countLabel.setForeground(new java.awt.Color(36, 36, 36));
        countLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        countLabel.setText("Encontrados 45");

        filterField.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        filterField.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        filterButton.setBackground(new java.awt.Color(193, 193, 193));
        filterButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        filterButton.setForeground(java.awt.Color.white);
        filterButton.setText("Filtrar");
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(36, 36, 36));
        jLabel1.setText("Atualizações pendentes");

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel2.setText("Os novos dados precisam ser aprovados pelo admnistrador antes de ficarem disponíveis no seu perfil, por favor aguarde ");

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel3.setText("a validação das mudanças e caso tenha alguma dúvida entre em contato com coordenacao@unesp.br");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(filterButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(countLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 706, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(1, 1, 1)
                .addComponent(jLabel3)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(countLabel)
                    .addComponent(filterField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
        clearTable();
        ArrayList<MilestoneSubmission> filtered = new ArrayList<>();
        String filter = filterField.getText();

        for (MilestoneSubmission milestone : controller.listPendentsMilestonesByEgress()) {
            if (milestone.getStatus().contains(filter)
                    || milestone.getCreatedAt().format(formatter).contains(filter)) {
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
