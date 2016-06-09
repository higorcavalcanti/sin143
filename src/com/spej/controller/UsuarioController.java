package com.spej.controller;

import com.spej.dao.UsuarioDao;
import com.spej.model.Usuario;
import java.util.ArrayList;

public class UsuarioController extends Controller<Usuario> {
    
    protected UsuarioDao dao;
    protected Usuario usuario;
    
    protected Usuario logado;

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioController() {
        this(new UsuarioDao(), null);
    }
    public UsuarioController(Usuario usuario) {
        this(new UsuarioDao(), usuario);
    }
    public UsuarioController(UsuarioDao usuarioDao, Usuario usuario) {
        this.dao = usuarioDao;
        this.usuario = usuario;
    }
    
    @Override
    public boolean update(Usuario antigo, Usuario novo) {
        return this.dao.update(antigo, novo);
    }    
    @Override
    public boolean delete(Usuario deletar) {
        return this.dao.delete(deletar);
    }    
    @Override
    public boolean insert(Usuario novo) {
        return this.dao.insert(novo);
    }
    
    
    @Override
    public boolean update(Usuario novo) {
        return this.dao.update(this.usuario, novo);
    }
    @Override
    public boolean delete() {
        return this.dao.delete(this.usuario);
    }
    @Override
    public boolean insert() {
        return this.dao.insert(this.usuario);
    }
    
    
    public Usuario getByMatricula(int matricula) {
        return this.dao.getByMatricula(matricula);
    }
    public ArrayList<Usuario> getAll() {
        return this.dao.getAll();
    }    
    public ArrayList<Usuario> getAllByDepartamento(int departamento) {
        return this.dao.getAllByDepartamento(departamento);
    }
    
    
    public boolean logar(String usuario, String senha) {
        //logado = this.dao.getByUsuarioSenha(usuario, senha);
        //return (logado != null);
        return true;
    }
}
