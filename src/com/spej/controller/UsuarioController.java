package com.spej.controller;

import com.spej.dao.UsuarioDao;
import com.spej.model.Usuario;
import java.util.ArrayList;

public class UsuarioController extends Controller<Usuario> {
        
    protected Usuario logado;
    
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

    public ArrayList<Usuario> getAllByDepartamento(int departamento) {
        return this.getDao().getAllByDepartamento(departamento);
    }
    
    
    public boolean logar(String usuario, String senha) {
        //logado = this.getDao().getByUsuarioSenha(usuario, senha);
        //return (logado != null);
        return true;
    }
}
