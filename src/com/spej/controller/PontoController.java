package com.spej.controller;

import com.spej.dao.PontoDao;
import com.spej.model.Ponto;
import com.spej.model.Usuario;
import java.util.Calendar;


public class PontoController  extends Controller<Ponto> {   
    
    public static final int PONTO_CRIADO = 1;
    public static final int PONTO_FECHADO = 2;
    
    @Override
    public PontoDao getDao() {
        return (PontoDao) this.dao;
    }
    
    public PontoController() {
        this(new PontoDao());
    }
    public PontoController(PontoDao pontoDao) {
        super(pontoDao);
    }   
    
    public Ponto getByUsuarioAtivo(Usuario user) {
        return this.getDao().getByUsuarioAtivo(user);
    }

    public Ponto baterPonto(Usuario user) {

        if(user == null) {
            throw new RuntimeException("Usuário Inválido!");
        }
        
        Ponto p = this.getByUsuarioAtivo(user);
        
        //Usuario está logado (com entrada e sem saida)
        if(p != null) {
            p.setSaida( new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()) );
            this.update(p);
        }
        else //Usuário não está logado (não existe entrada em saida)
        {
            p = new Ponto();
            p.setEntrada( new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()) );
            p.setSaida(null);
            p.setUsuarioMatricula(user.getMatricula());
            this.insert(p);
        }
        return p;
    }

}
