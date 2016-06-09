/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.dao;

import com.spej.model.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Higor
 */
public class DepartamentoDao extends Dao<Departamento> {

    private String getStringDepartamento() {
        return " id = ? nome = ? ";
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
                    "SET " + this.getStringDepartamento()+ "" +
                    "WHERE " + this.getStringDepartamento()+ "";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, novo.getId());
            stmt.setString(2, novo.getNome());
            
            stmt.setInt(3, antigo.getId());
            stmt.setString(4, antigo.getNome());            

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
                    "WHERE " + this.getStringDepartamento()+ "";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getId());
            stmt.setString(2, deletar.getNome());

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
    public ArrayList<Departamento> getAll() {
        String sql = "SELECT * FROM Departamentos";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return this.getListByPreparedStatement(stmt);
        }
        catch(Exception e) {
            
        }
        return new ArrayList<>();
    }

    @Override
    public ArrayList<Departamento> getListByPreparedStatement(PreparedStatement stmt) {
                
        ArrayList<Departamento> depts = new ArrayList<>();
        try {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                depts.add( this.byResultSet(rs) );
            }            
            stmt.close();
        }
        catch(Exception e) { 
            
        }
        return depts;
    }

    @Override
    public Departamento getByPreparedStatement(PreparedStatement stmt) {
        try {
            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next())
                throw new RuntimeException("Departamento não encontrado!");
            
            Departamento d = this.byResultSet(rs);
            
            stmt.close();
            return d;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }        
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
}