package com.spej.view;

import com.spej.controller.UsuarioController;

public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        setLocationRelativeTo( null ); // Centralizar a tela no meio
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE); // FEchar somente uma tela, não o programa todo
    }

    private void login(){
        //Validação para logar -> Usuario
        if (jTextUsuario.getText().length() == 0) {
            Mensagem.aviso(this, "O campo de usuário é obrigatório!", "Aviso");
        }else if (jTextSenha.getText().length() == 0) {
            Mensagem.aviso(this, "O campo de senha é obrigatório!", "Aviso");
        }else {             
            UsuarioController uc = new UsuarioController();
            try{
                if(uc.logar(jTextUsuario.getText(), String.valueOf(jTextSenha.getPassword())) ) 
                {
                    AdminPrincipal admPrinc = new AdminPrincipal();
                    admPrinc.setVisible(true);
                    this.setVisible(false);
                    return;
                } 
            } catch(Exception e) {
                
            }
            Mensagem.erro(this, "Usuario ou senha inválidos!", "Falha ao logar");
        }
         
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelLogin = new javax.swing.JPanel();
        jTexto = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelSenha = new javax.swing.JLabel();
        jBotaoEntrar = new javax.swing.JButton();
        jLogomarca = new javax.swing.JLabel();
        jTextSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanelLogin.setBackground(new java.awt.Color(238, 238, 238));

        jTexto.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTexto.setText("Administração do sistema");

        jTextUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextUsuarioActionPerformed(evt);
            }
        });

        jLabelUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelUsuario.setText("Usuario");

        jLabelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabelSenha.setText("Senha");

        jBotaoEntrar.setText("Entrar");
        jBotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBotaoEntrarActionPerformed(evt);
            }
        });

        jLogomarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/spej/imagem/logo.png"))); // NOI18N

        jTextSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextSenhaActionPerformed(evt);
            }
        });
        jTextSenha.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextSenhaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanelLoginLayout = new javax.swing.GroupLayout(jPanelLogin);
        jPanelLogin.setLayout(jPanelLoginLayout);
        jPanelLoginLayout.setHorizontalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsuario)
                            .addComponent(jBotaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelSenha)
                            .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLogomarca)
                        .addGap(79, 79, 79))))
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jTexto)
                .addContainerGap(201, Short.MAX_VALUE))
        );
        jPanelLoginLayout.setVerticalGroup(
            jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoginLayout.createSequentialGroup()
                .addGroup(jPanelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(147, 147, 147)
                        .addComponent(jLabelUsuario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(jLabelSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jBotaoEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoginLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jTexto)
                        .addGap(77, 77, 77)
                        .addComponent(jLogomarca)))
                .addContainerGap(150, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextUsuarioActionPerformed

    private void jBotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBotaoEntrarActionPerformed
       login();
    }//GEN-LAST:event_jBotaoEntrarActionPerformed

    private void jTextSenhaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextSenhaKeyPressed
        if (evt.getKeyCode() == evt.VK_ENTER){  
            login();
        }  
    }//GEN-LAST:event_jTextSenhaKeyPressed

    private void jTextSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextSenhaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBotaoEntrar;
    private javax.swing.JLabel jLabelSenha;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLogomarca;
    private javax.swing.JPanel jPanelLogin;
    private javax.swing.JPasswordField jTextSenha;
    private javax.swing.JTextField jTextUsuario;
    private javax.swing.JLabel jTexto;
    // End of variables declaration//GEN-END:variables
}
