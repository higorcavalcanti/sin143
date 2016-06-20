package com.spej.controller;

import com.spej.dao.DepartamentoDao;
import com.spej.model.Departamento;

public class DepartamentoController extends Controller<Departamento> {
        
    protected Departamento logado;
    
    @Override
    public DepartamentoDao getDao() {
        return (DepartamentoDao) this.dao;
    }

    
    public DepartamentoController() {
        this(new DepartamentoDao());
    }
    public DepartamentoController(DepartamentoDao departamentoDao) {
        super(departamentoDao);
    }
}
