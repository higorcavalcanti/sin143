/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import java.sql.Timestamp;

/**
 * Entidade que representa os pontos
 * @author Higor
 */
public class Ponto {
    private int id;
    private int usuario_id;
    private Timestamp entrada;
    private Timestamp saida;
    
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioMatricula() {
        return usuario_id;
    }

    public void setUsuarioMatricula(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public Timestamp getEntrada() {
        return entrada;
    }

    public void setEntrada(Timestamp entrada) {
        this.entrada = entrada;
    }

    public Timestamp getSaida() {
        return saida;
    }

    public void setSaida(Timestamp saida) {
        this.saida = saida;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public long getDiferenca() {
        return this.getSaida().getTime() - this.getEntrada().getTime();
    }
}
