/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.view;

import java.awt.Color;
import java.io.File;

/**
 *
 * @author Daniel
 */
public class BackupGerar extends javax.swing.JDialog {

    /**
     * Creates new form BackupGerar
     */
    public BackupGerar(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo( null ); // Centralizar a tela no meio
        getContentPane().setBackground(new Color(238,238,238));
        Escrita();
        FuncaoBackup();
        
    }
    
    public void Escrita(){
        texto.setText("Para sua segurança faça um backup semanal de seus dados!  É de suma importancia.");
    }
    
    public void FuncaoBackup(){
        try {
            //Conecta ao banco de dados 
            JFC_Salvar_Backup.setVisible(false);
        } catch (Exception e) {
            Mensagem.erro(this, e);
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

        jPanelGerenciarUsuario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        texto = new javax.swing.JLabel();
        jBotaoGerar = new javax.swing.JButton();
        JFC_Salvar_Backup = new javax.swing.JFileChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanelGerenciarUsuario.setBackground(new java.awt.Color(238, 238, 238));
        jPanelGerenciarUsuario.setToolTipText("Gerenciar Usuários");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Realizar Backup");

        jBotaoGerar.setText("Gerar backup");
        jBotaoGerar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jBotaoGerarMouseClicked(evt);
            }
        });
        jBotaoGerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoGerarActionPerformed(evt);
            }
        });

        JFC_Salvar_Backup.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        JFC_Salvar_Backup.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanelGerenciarUsuarioLayout = new javax.swing.GroupLayout(jPanelGerenciarUsuario);
        jPanelGerenciarUsuario.setLayout(jPanelGerenciarUsuarioLayout);
        jPanelGerenciarUsuarioLayout.setHorizontalGroup(
            jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(jLabel1))
                    .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                                .addComponent(jBotaoGerar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(JFC_Salvar_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelGerenciarUsuarioLayout.setVerticalGroup(
            jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(texto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jBotaoGerar)
                    .addComponent(JFC_Salvar_Backup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelGerenciarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelGerenciarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoGerarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jBotaoGerarMouseClicked
        
    }//GEN-LAST:event_jBotaoGerarMouseClicked

    private void jBotaoGerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoGerarActionPerformed
        
        try{
            String arquivo = null;
            JFC_Salvar_Backup.setVisible(true);
            
            int result = JFC_Salvar_Backup.showSaveDialog(null);
            File file = new File(arquivo); 
            
            
            
        
        } catch (Exception e) {
            Mensagem.erro(this, "Essa pagina ainda está em contrução" + e);
        }
    }//GEN-LAST:event_jBotaoGerarActionPerformed

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
            java.util.logging.Logger.getLogger(BackupGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BackupGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BackupGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BackupGerar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                BackupGerar dialog = new BackupGerar(new javax.swing.JFrame(), true);
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
    private javax.swing.JFileChooser JFC_Salvar_Backup;
    private javax.swing.JButton jBotaoGerar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanelGerenciarUsuario;
    private javax.swing.JLabel texto;
    // End of variables declaration//GEN-END:variables
}
