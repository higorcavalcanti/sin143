/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.dao;

import com.spej.model.Departamento;
import com.spej.view.Mensagem;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Higor
 */
public class DepartamentoDao extends Dao<Departamento> {

    public DepartamentoDao() {
        super("Departamentos");
    }

    @Override
    public boolean insert(Departamento novo) {
        String sql = "INSERT INTO Departamentos " +
                    "(id,nome)" +
                    " VALUES (?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, novo.getId());
            stmt.setString(2, novo.getNome());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean update(Departamento antigo, Departamento novo) {
        String sql = "UPDATE Departamentos " +
                    "SET id = ? nome = ?" +
                    "WHERE id = ?";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, novo.getId());
            stmt.setString(2, novo.getNome());
            
            stmt.setInt(3, antigo.getId());         

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }
        catch(Exception e) {
            
        }
        return false;    
    }

    @Override
    public boolean delete(Departamento deletar) {
        String sql = "DELETE FROM Usuarios " +
                    "WHERE id = ?";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getId());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }
        catch(Exception e) {
            
        }
        return false;        
    }

    @Override
    public Departamento byResultSet(ResultSet rs) {
        Departamento d = new Departamento();
        try {
            d.setId( rs.getInt("id") );
            d.setNome( rs.getString("nome") );
        }
        catch(Exception e) {
            
        }
        return d;
    }
    
    public Departamento getById(int id) {
        String sql = "SELECT * " +
            "FROM Departamentos " +
            "WHERE id = ? " +
            "LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            return this.getByPreparedStatement(stmt);
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }
}