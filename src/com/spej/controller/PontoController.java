package com.spej.controller;

import com.spej.dao.PontoDao;
import com.spej.model.Ponto;
import com.spej.model.Usuario;
import java.util.Calendar;


public class PontoController  extends Controller<Ponto> {   
    
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

    public void baterPonto(int matricula) {
        UsuarioController userC = new UsuarioController();        
        this.baterPonto( userC.getByMatricula( matricula ) );
    }    
    public void baterPonto(Usuario user) {

        if(user == null) {
            throw new RuntimeException("Usuário Inválido!");
        }
        
        Ponto p = this.getByUsuarioAtivo(user);
        
        //Usuario está logado (com entrada e sem saida)
        if(p != null) {
            System.out.println("nao null");
            
            p.setSaida( new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()) );
            this.update(p);
        }
        else //Usuário não está logado (não existe entrada em saida)
        {
            System.out.println("null");
            p = new Ponto();
            p.setEntrada( new java.sql.Timestamp(Calendar.getInstance().getTime().getTime()) );
            p.setSaida(null);
            p.setUsuarioMatricula(user.getMatricula());
            this.insert(p);
        }
    }

}
