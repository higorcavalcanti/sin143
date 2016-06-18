/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.view;

import com.spej.controller.RelatorioController;
import com.spej.model.Departamento;
import java.util.HashMap;

/**
 *
 * @author Daniel
 */
public class FiltroRelatorioUsuario extends javax.swing.JDialog {

    /**
     * Creates new form FiltroRelatorioFuncionarios
     * @param parent
     * @param modal
     */
    public FiltroRelatorioUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo( null ); // Centralizar a tela no meio
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jBotaoVisualizar = new javax.swing.JButton();
        jLabelNome1 = new javax.swing.JLabel();
        jComboDepartamento = new javax.swing.JComboBox<String>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(469, 300));
        setType(java.awt.Window.Type.UTILITY);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Relatório de Usuários");

        jBotaoVisualizar.setText("Visualizar");
        jBotaoVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoVisualizarActionPerformed(evt);
            }
        });

        jLabelNome1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome1.setText("Departamento");

        jComboDepartamento.setModel(new com.spej.model.DepartamentoComboBoxModel());
        jComboDepartamento.setMaximumSize(new java.awt.Dimension(6, 20));
        jComboDepartamento.setMinimumSize(new java.awt.Dimension(6, 20));
        jComboDepartamento.setPreferredSize(new java.awt.Dimension(6, 20));
        jComboDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboDepartamentoActionPerformed(evt);
            }
        });

        jLabel1.setText("OBS: Para relatório de todos usuários, não selecione departamento.");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelNome1)
                            .addComponent(jComboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addComponent(jBotaoVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel2)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabelNome1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboDepartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jBotaoVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        getAccessibleContext().setAccessibleName("Relátorio de Usuario");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboDepartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboDepartamentoActionPerformed

    private void jBotaoVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoVisualizarActionPerformed
        
        RelatorioController rc = new RelatorioController();

        /*
        JRResultSetDataSource relResult = new JRResultSetDataSource( );
        JasperPrint jpPrint = JasperFillManager.fillReport("iReports/relatorioUsuarios.jasper", new HashMap(), relResult);
        JasperViewer jv = new JasperViewer(jpPrint, false);
        jv.setVisible(true);
        jv.toFront();
        */
    }//GEN-LAST:event_jBotaoVisualizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoVisualizar;
    private javax.swing.JComboBox<String> jComboDepartamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelNome1;
    private javax.swing.JPanel jPanel;
    // End of variables declaration//GEN-END:variables
}
