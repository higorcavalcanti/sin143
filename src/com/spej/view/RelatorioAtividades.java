/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.view;

import com.spej.controller.AtividadeController;
import com.spej.model.Atividade;
import com.spej.model.Ponto;
import com.spej.model.Usuario;

/**
 * Tela para preenchimento do relatório de atividades (Acessivel após bater ponto)
 * @author Daniel
 */
public class RelatorioAtividades extends javax.swing.JDialog {

    private Usuario user;
    private Ponto ponto;
    
    /**
     * Creates new form RelatorioAtividades
     * @param user
     * @param ponto
     */
    public RelatorioAtividades(Usuario user, Ponto ponto) {
        
        this.user = user;
        this.ponto = ponto;
        
        initComponents();
        setLocationRelativeTo( null ); // Centralizar a tela no meio
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // FEchar somente uma tela, não o programa todo
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPainelRelatorioAtividades = new javax.swing.JPanel();
        jlLabelTituloRelatorio = new javax.swing.JLabel();
        jLabelMensagemSubtitulo = new javax.swing.JLabel();
        jLabelDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaDescricao = new javax.swing.JTextArea();
        jLabelUsuario = new javax.swing.JLabel();
        jBotaoLimpar = new javax.swing.JButton();
        jBotaoEnviar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setModal(true);
        setResizable(false);

        jPainelRelatorioAtividades.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPainelRelatorioAtividades.setMaximumSize(null);
        jPainelRelatorioAtividades.setPreferredSize(new java.awt.Dimension(717, 459));

        jlLabelTituloRelatorio.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jlLabelTituloRelatorio.setText("Relatório de Atividades");

        jLabelMensagemSubtitulo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelMensagemSubtitulo.setText("Por favor, preencha o relatório de atividades, é de suma importancia!");

        jLabelDescricao.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelDescricao.setText("Desceva suas atividades");

        jTextAreaDescricao.setColumns(20);
        jTextAreaDescricao.setRows(5);
        jScrollPane1.setViewportView(jTextAreaDescricao);

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabelUsuario.setText( this.user.getNome() );

        jBotaoLimpar.setText("Limpar");
        jBotaoLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoLimparActionPerformed(evt);
            }
        });

        jBotaoEnviar.setText("Enviar");
        jBotaoEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPainelRelatorioAtividadesLayout = new javax.swing.GroupLayout(jPainelRelatorioAtividades);
        jPainelRelatorioAtividades.setLayout(jPainelRelatorioAtividadesLayout);
        jPainelRelatorioAtividadesLayout.setHorizontalGroup(
            jPainelRelatorioAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPainelRelatorioAtividadesLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addGroup(jPainelRelatorioAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPainelRelatorioAtividadesLayout.createSequentialGroup()
                        .addComponent(jBotaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBotaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabelUsuario)
                    .addComponent(jlLabelTituloRelatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelMensagemSubtitulo)
                    .addComponent(jLabelDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 505, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPainelRelatorioAtividadesLayout.setVerticalGroup(
            jPainelRelatorioAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPainelRelatorioAtividadesLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jlLabelTituloRelatorio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelMensagemSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(jLabelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPainelRelatorioAtividadesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBotaoLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotaoEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPainelRelatorioAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, 565, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPainelRelatorioAtividades, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoEnviarActionPerformed
        Atividade a = new Atividade();
        
        try {
            
            AtividadeController ac = new AtividadeController();
            
            a.setRelatorio( jTextAreaDescricao.getText() );
            a.setObservacao( jTextAreaObservacao.getText() );
            a.setPonto_id( ponto.getId() );
            
            ac.insert(a);
            Mensagem.sucesso(this, "Atividade enviada!");
            this.dispose();
        }
        catch(RuntimeException e) {
            Mensagem.erro(this, e.getMessage(), "Falha ao cadastrar relatório");
        }
        catch(Exception e) {
            Mensagem.erro(this, "Erro desconhecido!\n" + e.getMessage(), "Falha ao cadastrar relatório");
        }
    }//GEN-LAST:event_jBotaoEnviarActionPerformed

    private void jBotaoLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoLimparActionPerformed
        jTextAreaDescricao.setText("");
        jTextAreaObservacao.setText("");
    }//GEN-LAST:event_jBotaoLimparActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoEnviar;
    private javax.swing.JButton jBotaoLimpar;
    private javax.swing.JLabel jLabelDescricao;
    private javax.swing.JLabel jLabelMensagemSubtitulo;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPainelRelatorioAtividades;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaDescricao;
    private javax.swing.JLabel jlLabelTituloRelatorio;
    // End of variables declaration//GEN-END:variables
}
