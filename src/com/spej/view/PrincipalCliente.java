/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.view;

/**
 *
 * @author Daniel
 */
public class PrincipalCliente extends javax.swing.JFrame {

    /**
     * Creates new form PrincipalCliente
     */
    public PrincipalCliente() {
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

        jPainelPrincipalClientes = new javax.swing.JPanel();
        JLabelLogo = new javax.swing.JLabel();
        jCaixaIdentificacao = new javax.swing.JTextField();
        JBaterPonto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListaAtivos = new javax.swing.JList<String>();
        jBotaoTeste = new javax.swing.JButton();
        jBotaoAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPainelPrincipalClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPainelPrincipalClientes.setMaximumSize(null);
        jPainelPrincipalClientes.setPreferredSize(new java.awt.Dimension(780, 474));

        JLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spej/imagem/logo.png"))); // NOI18N

        jCaixaIdentificacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCaixaIdentificacaoActionPerformed(evt);
            }
        });

        JBaterPonto.setText("Bater Ponto");
        JBaterPonto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBaterPontoActionPerformed(evt);
            }
        });

        jListaAtivos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jListaAtivos);

        jBotaoTeste.setText("Testar tela de relatorio");
        jBotaoTeste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoTesteActionPerformed(evt);
            }
        });

        jBotaoAdmin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spej/imagem/administracao.png"))); // NOI18N
        jBotaoAdmin.setFocusable(false);
        jBotaoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoAdminActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPainelPrincipalClientesLayout = new javax.swing.GroupLayout(jPainelPrincipalClientes);
        jPainelPrincipalClientes.setLayout(jPainelPrincipalClientesLayout);
        jPainelPrincipalClientesLayout.setHorizontalGroup(
            jPainelPrincipalClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelPrincipalClientesLayout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(jPainelPrincipalClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jBotaoTeste)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPainelPrincipalClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPainelPrincipalClientesLayout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(JLabelLogo))
                        .addGroup(jPainelPrincipalClientesLayout.createSequentialGroup()
                            .addComponent(jCaixaIdentificacao, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(JBaterPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(128, 128, 128))
            .addGroup(jPainelPrincipalClientesLayout.createSequentialGroup()
                .addComponent(jBotaoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPainelPrincipalClientesLayout.setVerticalGroup(
            jPainelPrincipalClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelPrincipalClientesLayout.createSequentialGroup()
                .addComponent(jBotaoAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPainelPrincipalClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCaixaIdentificacao)
                    .addComponent(JBaterPonto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBotaoTeste)
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPainelPrincipalClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPainelPrincipalClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JBaterPontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBaterPontoActionPerformed

    }//GEN-LAST:event_JBaterPontoActionPerformed

    private void jCaixaIdentificacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCaixaIdentificacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCaixaIdentificacaoActionPerformed

    private void jBotaoTesteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoTesteActionPerformed
        RelatorioAtividades rAtividades = new RelatorioAtividades();
        rAtividades.setVisible(true);
    }//GEN-LAST:event_jBotaoTesteActionPerformed

    private void jBotaoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoAdminActionPerformed
        Login login = new Login();
        login.setVisible(true);
    }//GEN-LAST:event_jBotaoAdminActionPerformed

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
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrincipalCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrincipalCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBaterPonto;
    private javax.swing.JLabel JLabelLogo;
    private javax.swing.JButton jBotaoAdmin;
    private javax.swing.JButton jBotaoTeste;
    private javax.swing.JTextField jCaixaIdentificacao;
    private javax.swing.JList<String> jListaAtivos;
    private javax.swing.JPanel jPainelPrincipalClientes;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
