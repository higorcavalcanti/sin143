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
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Higor
 * @param <T> Tipo de Objeto que será retornado
 */
public abstract class Dao<T> {
    
    protected Connection connection;  
    protected PreparedStatement stmt;
    protected String table;

    public Dao(String table) {
        this.connection = ConnectionFactory.getConnection();
        this.table = table;
    }
    
    /**
     * 
     * @return Verdadeiro se conseguiu inserir
     */
    public abstract boolean insert(T novo);
    
    
    /**
     * 
     * @return Verdadeiro se conseguiu atualizar
     */
    public abstract boolean update(T antigo, T novo);
    
    
    /**
     * 
     * @return Verdadeiro se conseguiu deletar
     */
    public abstract boolean delete(T deletar);
    
        
    /**
     * 
     * @param rs
     * @return 
     */
    public abstract T byResultSet(ResultSet rs);
    
    
    /**
     * Retorna todos os itens cadastrados
     * @return lista de itens
     */
    public ArrayList<T> getAll() {
        return this.getAll("");
    }
    public ArrayList<T> getAll(String WHERE) {
        String sql = "SELECT * FROM " + this.table + (WHERE.length() != 0 ? "WHERE "+WHERE : "");
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return this.getListByPreparedStatement(stmt);
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());   
        }
    }
    
    
    /**
     * Retorna uma array list de
     * @param stmt
     * @return 
     */
    public ArrayList<T> getListByPreparedStatement( PreparedStatement stmt ) {
        
        ArrayList<T> list = new ArrayList<>();
        try {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                list.add( this.byResultSet(rs) );
            }            
            stmt.close();
        }
        catch(SQLException e) { 
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return list;
    }
    
    
    /**
     * Retorna UM objeto
     * @param stmt 
     * @return Object
     */
        public T getByPreparedStatement( PreparedStatement stmt ) {
        try {
            ResultSet rs = stmt.executeQuery();
            
            //if(!rs.next())
                //throw new RuntimeException("Usuario não encontrado!");
            if(rs.next()) {
                T result = this.byResultSet(rs);

                stmt.close();
                return result;
            }
            return null;
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }        
    }
}
