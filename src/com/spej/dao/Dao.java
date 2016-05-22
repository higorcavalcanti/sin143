/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.dao;

import com.spej.persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Higor
 * @param <T> Tipo de Objeto que será retornado
 */
public abstract class Dao<T> {
    
    protected Connection connection;  
    protected PreparedStatement stmt;

    public Dao() {
        this.connection = ConnectionFactory.getConnection();
    }
    
    /**
     * 
     * @return Verdadeiro se conseguiu inserir
     */
    public abstract boolean insert();
    
    
    /**
     * 
     * @return Verdadeiro se conseguiu atualizar
     */
    public abstract boolean update(T novo);
    
    
    /**
     * 
     * @return Verdadeiro se conseguiu deletar
     */
    public abstract boolean delete();
    
    
    /**
     * Retorna uma array list de
     * @param stmt
     * @return 
     */
    public abstract ArrayList<T> getListByPreparedStatement(PreparedStatement stmt);
    
    
    /**
     * Retorna UM objeto
     * @param stmt 
     * @return Object
     */
    public abstract T getByPreparedStatement(PreparedStatement stmt);
    
    /**
     * 
     * @param rs
     * @return 
     */
    public abstract T byResultSet(ResultSet rs);
}
