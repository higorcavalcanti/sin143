package com.spej.controller;

import com.spej.dao.UsuarioDao;
import com.spej.model.Usuario;
import java.util.ArrayList;

public class UsuarioController extends Controller<Usuario> {
        
    private static Usuario logado;

    public static Usuario getLogado() {
        return logado;
    }
    public static void setLogado(Usuario logado) {
        UsuarioController.logado = logado;
    }
    
    
    @Override
    public UsuarioDao getDao() {
        return (UsuarioDao) this.dao;
    }

    
    public UsuarioController() {
        this(new UsuarioDao());
    }
    public UsuarioController(UsuarioDao usuarioDao) {
        super(usuarioDao);
    }
    
    
    public Usuario getByMatricula(int matricula) {
        return this.getDao().getByMatricula(matricula);
    }
    
    public boolean logar(String usuario, String senha) {
        UsuarioController.setLogado( this.getDao().getByUsuarioSenha(usuario, senha) );
        return (UsuarioController.getLogado() != null);
        //return true;
    }
}
