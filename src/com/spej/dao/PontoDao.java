/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.dao;

import com.spej.model.Ponto;
import com.spej.model.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Higor
 */
public class PontoDao extends Dao<Ponto> {
    
    public PontoDao() {
        super("Ponto");
    }
    
    @Override
    public boolean insert(Ponto novo) {
                
        String sql = "INSERT INTO Ponto " +
                    "(usuario_matricula,entrada,saida)" +
                    " VALUES (?,?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // seta os valores
            stmt.setInt(1, novo.getUsuarioMatricula());
            stmt.setTimestamp(2, novo.getEntrada());
            stmt.setTimestamp(3, novo.getSaida());

            // executa
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    novo.setId( rs.getInt(1) );
                }
            }
            
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
                    "SET id = ?, usuario_matricula = ?, entrada = ?, saida = ? " +
                    "WHERE id = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            // seta os valores
            stmt.setInt(1, novo.getId());
            stmt.setInt(2, novo.getUsuarioMatricula());
            stmt.setTimestamp(3, novo.getEntrada());
            stmt.setTimestamp(4, novo.getSaida());
            
            stmt.setInt(5, antigo.getId());

            // executa
            stmt.executeUpdate();
            
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    novo.setId( rs.getInt(1) );
                }
            }            
            
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
                    "WHERE id = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getId());

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
            p.setUsuarioMatricula( user.getInt("usuario_matricula") );
            p.setEntrada( user.getTimestamp("entrada") );
            p.setSaida( user.getTimestamp("saida") );
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return p;
    }
    
    
    public Ponto getByUsuarioAtivo(Usuario user) {
        String sql = "SELECT * " +
                    "FROM Ponto " +
                    "WHERE usuario_matricula = ? AND saida IS NULL " +
                    "ORDER BY id DESC " +
                    "LIMIT 1";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, user.getMatricula());
            stmt.setMaxRows(1);
            return this.getByPreparedStatement(stmt);
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }
}
