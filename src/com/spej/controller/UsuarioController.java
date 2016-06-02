package com.spej.controller;

import com.spej.dao.UsuarioDao;
import com.spej.model.Usuario;
import java.util.ArrayList;

public class UsuarioController extends Controller<Usuario> {
    
    protected UsuarioDao dao;

    public UsuarioController() {
        this(new UsuarioDao());
    }
    public UsuarioController(UsuarioDao usuarioDao) {
        this.dao = usuarioDao;
    }
    
    @Override
    public boolean update(Usuario novo) {
        return this.dao.update(novo);
    }    
    @Override
    public boolean delete() {
        return this.dao.delete();
    }    
    @Override
    public boolean insert(Usuario novo) {
        return this.dao.insert();
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
}
