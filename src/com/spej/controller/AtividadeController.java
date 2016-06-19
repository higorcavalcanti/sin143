package com.spej.controller;

import com.spej.dao.AtividadeDao;
import com.spej.model.Atividade;


public class AtividadeController  extends Controller<Atividade> {   
    
    @Override
    public AtividadeDao getDao() {
        return (AtividadeDao) this.dao;
    }
    
    public AtividadeController() {
        this(new AtividadeDao());
    }
    public AtividadeController(AtividadeDao atividadeDao) {
        super(atividadeDao);
    }   

}
