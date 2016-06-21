/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.view;

import com.spej.controller.UsuarioController;
import com.spej.model.Usuario;
import com.spej.model.UsuarioTableModel;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 * Tela para gerencia de usuários (Apenas visualização, a inserção/atualização é em CadastrarUsuário)
 */
public class GerenciarUsuario extends javax.swing.JDialog {

    /**
     * Creates new form GerenciarUsuario
     */
    public GerenciarUsuario() {
        initComponents();
        setLocationRelativeTo( null ); // Centralizar a tela no meio
        getContentPane().setBackground(new Color(238,238,238));
        
        jBotaoEditar.setEnabled(false);
        jBotaoExcluir.setEnabled(false);
        
        
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
        jLabelNome = new javax.swing.JLabel();
        jTextNome = new javax.swing.JTextField();
        jTb1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jTableUsuarios.setRowHeight(23);
        jBotaoEditar = new javax.swing.JButton();
        jBotaoExcluir = new javax.swing.JButton();
        jBotaoBuscar = new javax.swing.JButton();
        jBotaoNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(238, 238, 238));
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);

        jPanelGerenciarUsuario.setBackground(new java.awt.Color(238, 238, 238));
        jPanelGerenciarUsuario.setToolTipText("Gerenciar Usuários");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Gerenciar Usuários");

        jLabelNome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelNome.setText("Nome");

        jTextNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNomeActionPerformed(evt);
            }
        });
        jTextNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextNomeKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextNomeKeyTyped(evt);
            }
        });

        jTableUsuarios.setModel( new com.spej.model.UsuarioTableModel() );
        this.atualizarTabela();
        jTableUsuarios.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jTb1.setViewportView(jTableUsuarios);
        jTableUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                if(jTableUsuarios.getSelectedRowCount() > 0) {
                    jBotaoEditar.setEnabled(true);
                    jBotaoExcluir.setEnabled(true);
                } else {
                    jBotaoEditar.setEnabled(false);
                    jBotaoExcluir.setEnabled(false);
                }
            }
        });

        jBotaoEditar.setText("Editar");
        jBotaoEditar.setEnabled(false);
        jBotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoEditarActionPerformed(evt);
            }
        });

        jBotaoExcluir.setText("Excluir");
        jBotaoExcluir.setEnabled(false);
        jBotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoExcluirActionPerformed(evt);
            }
        });

        jBotaoBuscar.setText("Buscar");
        jBotaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoBuscarActionPerformed(evt);
            }
        });

        jBotaoNovo.setText("Novo");
        jBotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGerenciarUsuarioLayout = new javax.swing.GroupLayout(jPanelGerenciarUsuario);
        jPanelGerenciarUsuario.setLayout(jPanelGerenciarUsuarioLayout);
        jPanelGerenciarUsuarioLayout.setHorizontalGroup(
            jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                        .addComponent(jLabelNome)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGerenciarUsuarioLayout.createSequentialGroup()
                        .addGap(0, 130, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(221, 221, 221))
                    .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                        .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTb1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelGerenciarUsuarioLayout.createSequentialGroup()
                                .addComponent(jTextNome, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBotaoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                                .addComponent(jBotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jBotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanelGerenciarUsuarioLayout.setVerticalGroup(
            jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGerenciarUsuarioLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jLabelNome)
                .addGap(1, 1, 1)
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jBotaoBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addComponent(jTextNome))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTb1, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelGerenciarUsuarioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBotaoEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBotaoNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
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

        jPanelGerenciarUsuario.getAccessibleContext().setAccessibleName("");
        jPanelGerenciarUsuario.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoNovoActionPerformed
        new CadastrarUsuario().setVisible(true);
        this.atualizarTabela();
    }//GEN-LAST:event_jBotaoNovoActionPerformed

    private void jBotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoEditarActionPerformed
        this.editarUsuario();
    }//GEN-LAST:event_jBotaoEditarActionPerformed

    private void jBotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoExcluirActionPerformed
        UsuarioTableModel ut = (UsuarioTableModel) jTableUsuarios.getModel();
        Usuario u = ut.getRowObject( jTableUsuarios.getSelectedRow() );
        
        int dialogResult = JOptionPane.showConfirmDialog (this, 
                "Tem certeza que deseja deletar este usuário?\n" + u,
                "Aviso", 
                JOptionPane.YES_NO_OPTION
        );
        
        if( dialogResult == JOptionPane.YES_OPTION) {
            UsuarioController uc = new UsuarioController();
            uc.delete(u);
        }        
        this.atualizarTabela();
    }//GEN-LAST:event_jBotaoExcluirActionPerformed

    private void jBotaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoBuscarActionPerformed
        this.atualizarTabela(jTextNome.getText());
    }//GEN-LAST:event_jBotaoBuscarActionPerformed

    private void jTextNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNomeActionPerformed

    }//GEN-LAST:event_jTextNomeActionPerformed

    private void jTextNomeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNomeKeyTyped
        this.atualizarTabela(jTextNome.getText());
    }//GEN-LAST:event_jTextNomeKeyTyped

    private void jTextNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextNomeKeyPressed
        
    }//GEN-LAST:event_jTextNomeKeyPressed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked
        if (evt.getClickCount() == 2) {
            this.editarUsuario();
        }
    }//GEN-LAST:event_jTableUsuariosMouseClicked
       
    
    private void editarUsuario() {
        UsuarioTableModel ut = (UsuarioTableModel) jTableUsuarios.getModel();
        Usuario u = ut.getRowObject( jTableUsuarios.getSelectedRow() );

        new CadastrarUsuario(u).setVisible(true);        
        this.atualizarTabela();
    }
    
    private void atualizarTabela() {
        this.atualizarTabela("");
    }
    private void atualizarTabela(String search) {
        jTableUsuarios.setModel( new com.spej.model.UsuarioTableModel( search ) );
        
        jTableUsuarios.getColumnModel().getColumn(0).setMinWidth(80);
        jTableUsuarios.getColumnModel().getColumn(0).setMaxWidth(80);
        jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(80);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoBuscar;
    private javax.swing.JButton jBotaoEditar;
    private javax.swing.JButton jBotaoExcluir;
    private javax.swing.JButton jBotaoNovo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelNome;
    private javax.swing.JPanel jPanelGerenciarUsuario;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JScrollPane jTb1;
    private javax.swing.JTextField jTextNome;
    // End of variables declaration//GEN-END:variables
}
