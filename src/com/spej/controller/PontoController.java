package com.spej.controller;

import com.spej.dao.PontoDao;
import com.spej.model.Ponto;

public class PontoController  extends Controller<Ponto>{   
    
    @Override
    public PontoDao getDao() {
        return (PontoDao) this.dao;
    }
    
    public PontoController() {
        this(new PontoDao(), null);
    }
    public PontoController(Ponto ponto) {
        this(new PontoDao(), ponto);
    }
    public PontoController(PontoDao pontoDao, Ponto ponto) {
        super(pontoDao, ponto);
    }   

}
