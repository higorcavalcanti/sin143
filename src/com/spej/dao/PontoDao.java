/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.dao;

import com.spej.model.Ponto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Higor
 */
public class PontoDao extends Dao<Ponto> {
    
    public PontoDao() {
        super("Ponto");
    }
    
    public String getStringPonto() {
        return " usuario_id = ? entrada = ? saida = ? ";
    }

    @Override
    public boolean insert(Ponto novo) {
                
        String sql = "INSERT INTO Ponto " +
                    "(usuario_id,entrada,saida)" +
                    " VALUES (?,?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, novo.getUsuario_id());
            stmt.setDate(2, novo.getEntrada());
            stmt.setDate(3, novo.getSaida());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        } 
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }

    @Override
    public boolean update(Ponto antigo, Ponto novo) {
        String sql = "UPDATE Ponto " +
                    "SET " + this.getStringPonto() + "" +
                    "WHERE " + this.getStringPonto() + "";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, novo.getUsuario_id());
            stmt.setDate(2, novo.getEntrada());
            stmt.setDate(3, novo.getSaida());
            
            stmt.setInt(4, novo.getUsuario_id());
            stmt.setDate(5, novo.getEntrada());
            stmt.setDate(6, novo.getSaida());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }

    @Override
    public boolean delete(Ponto deletar) {
       String sql = "DELETE FROM Ponto " +
                    "WHERE " + this.getStringPonto()+ "";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getUsuario_id());
            stmt.setDate(2, deletar.getEntrada());
            stmt.setDate(3, deletar.getSaida());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }

    @Override
    public Ponto byResultSet(ResultSet user) {
        Ponto p = new Ponto();
        try {
            p.setId( user.getInt("id") );
            p.setUsuario_id( user.getInt("usuario_id") );
            p.setEntrada( user.getDate("entrada") );
            p.setSaida( user.getDate("saida") );
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return p;
    }
}
