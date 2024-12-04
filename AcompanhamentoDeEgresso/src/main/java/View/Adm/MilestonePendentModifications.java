/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View.Adm;

import Controller.SystemController;
import Model.Administrator;
import Model.Milestone;
import Model.MilestoneSubmission;
import View.CustomComponents.RoundedBorder;
import java.awt.Color;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

/**
 *
 * @author Karol
 */
public class MilestonePendentModifications extends javax.swing.JDialog {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final MilestoneSubmission pendentMilestone;
    private final SystemController controller = SystemController.getInstance();

    /**
     * Creates new form MilestonePendentModifications
     *
     * @param parent
     * @param modal
     * @param pendentMilestone
     */
    public MilestonePendentModifications(java.awt.Frame parent, boolean modal, MilestoneSubmission pendentMilestone
    ) {
        super(parent, modal);
        initComponents();

        this.pendentMilestone = pendentMilestone;
        initData();
        if (!(controller.getUserSession() instanceof Administrator)) {
            panel.remove(refuseButton);
            panel.remove(approveButton);
        }
    }

    private void initData() {
        Milestone oldMilestone = this.pendentMilestone.getOldMilestone();
        if (oldMilestone != null) {
            oldInstituition.setText(oldMilestone.getInstitution());
            oldRole.setText(oldMilestone.getRole());
            oldDescription.setText(oldMilestone.getDescription());
            oldStartDate.setText(oldMilestone.getStartDate().format(formatter));
            oldFinishDate.setText(oldMilestone.getFinishDate().format(formatter));
            oldCurrent.setSelected(oldMilestone.isCurrent());
        }

        Milestone newMilestone = this.pendentMilestone.getNewMilestone();
        newInstituition.setText(newMilestone.getInstitution());
        newRole.setText(newMilestone.getRole());
        newDescription.setText(newMilestone.getDescription());
        newStartDate.setText(newMilestone.getStartDate().format(formatter));
        newFinishDate.setText(newMilestone.getFinishDate().format(formatter));
        newCurrent.setSelected(newMilestone.isCurrent());
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
        panel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        newRole = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        newStartDate = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        newFinishDate = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        newDescription = new javax.swing.JTextArea();
        newCurrent = new javax.swing.JCheckBox();
        jLabel25 = new javax.swing.JLabel();
        newInstituition = new javax.swing.JTextField();
        title4 = new javax.swing.JLabel();
        approveButton = new javax.swing.JButton();
        refuseButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        oldRole = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        oldStartDate = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        oldFinishDate = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        oldDescription = new javax.swing.JTextArea();
        oldCurrent = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        oldInstituition = new javax.swing.JTextField();
        title3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(252, 252, 252));

        jPanel1.setBackground(new java.awt.Color(252, 252, 252));

        panel.setBackground(new java.awt.Color(252, 252, 252));
        panel.setPreferredSize(new java.awt.Dimension(413, 510));

        jLabel21.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(36, 36, 36));
        jLabel21.setText("Cargo ou  principal atividade");

        newRole.setEditable(false);
        newRole.setBackground(new java.awt.Color(255, 255, 255));
        newRole.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        newRole.setForeground(new java.awt.Color(36, 36, 36));
        newRole.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel22.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(36, 36, 36));
        jLabel22.setText("Data de início");

        newStartDate.setEditable(false);
        newStartDate.setBackground(new java.awt.Color(255, 255, 255));
        newStartDate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        newStartDate.setForeground(new java.awt.Color(36, 36, 36));
        newStartDate.setToolTipText("dd/MM/yyyy");
        newStartDate.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        newStartDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newStartDateActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(36, 36, 36));
        jLabel23.setText("Data de término/saída");

        newFinishDate.setEditable(false);
        newFinishDate.setBackground(new java.awt.Color(255, 255, 255));
        newFinishDate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        newFinishDate.setForeground(new java.awt.Color(36, 36, 36));
        newFinishDate.setToolTipText("dd/MM/yyyy");
        newFinishDate.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel24.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(36, 36, 36));
        jLabel24.setText("Descrição das atividades, projetos e pesquisas");

        newDescription.setEditable(false);
        newDescription.setBackground(new java.awt.Color(255, 255, 255));
        newDescription.setColumns(20);
        newDescription.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        newDescription.setForeground(new java.awt.Color(36, 36, 36));
        newDescription.setRows(5);
        newDescription.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        jScrollPane5.setViewportView(newDescription);

        newCurrent.setBackground(new java.awt.Color(255, 255, 255));
        newCurrent.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        newCurrent.setForeground(new java.awt.Color(36, 36, 36));
        newCurrent.setText("Atualmente");
        newCurrent.setEnabled(false);
        newCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newCurrentActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(36, 36, 36));
        jLabel25.setText("Instituição/Empresa/Entidade");

        newInstituition.setEditable(false);
        newInstituition.setBackground(new java.awt.Color(255, 255, 255));
        newInstituition.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        newInstituition.setForeground(new java.awt.Color(36, 36, 36));
        newInstituition.setToolTipText("");
        newInstituition.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        newInstituition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newInstituitionActionPerformed(evt);
            }
        });

        title4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        title4.setForeground(new java.awt.Color(36, 36, 36));
        title4.setText("Novos dados");

        approveButton.setBackground(new java.awt.Color(134, 241, 128));
        approveButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        approveButton.setForeground(new java.awt.Color(255, 255, 255));
        approveButton.setText("Aprovar");
        approveButton.setBorder(null);
        approveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveButtonActionPerformed(evt);
            }
        });

        refuseButton.setBackground(new java.awt.Color(243, 111, 111));
        refuseButton.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        refuseButton.setForeground(new java.awt.Color(255, 255, 255));
        refuseButton.setText("Recusar");
        refuseButton.setBorder(null);
        refuseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refuseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5)
                    .addComponent(newRole)
                    .addComponent(newInstituition)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                        .addGap(0, 91, Short.MAX_VALUE)
                        .addComponent(refuseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel22)
                            .addComponent(newStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23)
                            .addComponent(newFinishDate)))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel25)
                            .addComponent(newCurrent)
                            .addComponent(jLabel24))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(title4)
                .addGap(18, 18, 18)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(newInstituition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel22))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(newFinishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(newStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(newCurrent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refuseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        jPanel5.setBackground(new java.awt.Color(252, 252, 252));

        jLabel16.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(36, 36, 36));
        jLabel16.setText("Cargo ou  principal atividade");

        oldRole.setEditable(false);
        oldRole.setBackground(new java.awt.Color(255, 255, 255));
        oldRole.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        oldRole.setForeground(new java.awt.Color(36, 36, 36));
        oldRole.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel17.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(36, 36, 36));
        jLabel17.setText("Data de início");

        oldStartDate.setEditable(false);
        oldStartDate.setBackground(new java.awt.Color(255, 255, 255));
        oldStartDate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        oldStartDate.setForeground(new java.awt.Color(36, 36, 36));
        oldStartDate.setToolTipText("dd/MM/yyyy");
        oldStartDate.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel18.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(36, 36, 36));
        jLabel18.setText("Data de término/saída");

        oldFinishDate.setEditable(false);
        oldFinishDate.setBackground(new java.awt.Color(255, 255, 255));
        oldFinishDate.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        oldFinishDate.setForeground(new java.awt.Color(36, 36, 36));
        oldFinishDate.setToolTipText("dd/MM/yyyy");
        oldFinishDate.setBorder(new RoundedBorder(8, new Color(193,193,193)));

        jLabel19.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(36, 36, 36));
        jLabel19.setText("Descrição das atividades, projetos e pesquisas");

        oldDescription.setEditable(false);
        oldDescription.setBackground(new java.awt.Color(255, 255, 255));
        oldDescription.setColumns(20);
        oldDescription.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        oldDescription.setForeground(new java.awt.Color(36, 36, 36));
        oldDescription.setRows(5);
        oldDescription.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        jScrollPane4.setViewportView(oldDescription);

        oldCurrent.setBackground(new java.awt.Color(255, 255, 255));
        oldCurrent.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        oldCurrent.setForeground(new java.awt.Color(36, 36, 36));
        oldCurrent.setText("Atualmente");
        oldCurrent.setEnabled(false);
        oldCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldCurrentActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(36, 36, 36));
        jLabel20.setText("Instituição/Empresa/Entidade");

        oldInstituition.setEditable(false);
        oldInstituition.setBackground(new java.awt.Color(255, 255, 255));
        oldInstituition.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        oldInstituition.setForeground(new java.awt.Color(36, 36, 36));
        oldInstituition.setToolTipText("");
        oldInstituition.setBorder(new RoundedBorder(8, new Color(193,193,193)));
        oldInstituition.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oldInstituitionActionPerformed(evt);
            }
        });

        title3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        title3.setForeground(new java.awt.Color(36, 36, 36));
        title3.setText("Dados originais");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addContainerGap(127, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(title3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(oldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(oldFinishDate, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)))
                            .addComponent(oldRole, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(oldInstituition, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(oldCurrent, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap(28, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(title3)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oldRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(oldInstituition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(oldFinishDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(oldStartDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(oldCurrent)
                .addGap(93, 93, 93))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 534, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void oldCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldCurrentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldCurrentActionPerformed

    private void oldInstituitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oldInstituitionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_oldInstituitionActionPerformed

    private void newCurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newCurrentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newCurrentActionPerformed

    private void newInstituitionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newInstituitionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newInstituitionActionPerformed

    private void approveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveButtonActionPerformed
        String message = controller.validateMilestone(pendentMilestone, true);
        JOptionPane.showMessageDialog(null, message, "Marco aprovado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_approveButtonActionPerformed

    private void refuseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refuseButtonActionPerformed
        String message = controller.validateMilestone(pendentMilestone, false);
        JOptionPane.showMessageDialog(null, message, "Marco recusado", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_refuseButtonActionPerformed

    private void newStartDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newStartDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newStartDateActionPerformed

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
            java.util.logging.Logger.getLogger(MilestonePendentModifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MilestonePendentModifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MilestonePendentModifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MilestonePendentModifications.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MilestonePendentModifications dialog = new MilestonePendentModifications(new javax.swing.JFrame(), true, null);
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
    private javax.swing.JButton approveButton;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JCheckBox newCurrent;
    private javax.swing.JTextArea newDescription;
    private javax.swing.JTextField newFinishDate;
    private javax.swing.JTextField newInstituition;
    private javax.swing.JTextField newRole;
    private javax.swing.JTextField newStartDate;
    private javax.swing.JCheckBox oldCurrent;
    private javax.swing.JTextArea oldDescription;
    private javax.swing.JTextField oldFinishDate;
    private javax.swing.JTextField oldInstituition;
    private javax.swing.JTextField oldRole;
    private javax.swing.JTextField oldStartDate;
    private javax.swing.JPanel panel;
    private javax.swing.JButton refuseButton;
    private javax.swing.JLabel title3;
    private javax.swing.JLabel title4;
    // End of variables declaration//GEN-END:variables
}
