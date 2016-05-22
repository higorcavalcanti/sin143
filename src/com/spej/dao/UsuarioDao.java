package com.spej.dao;

import com.spej.model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends Dao<Usuario> {

    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao(Usuario usuario) {
        super();
        this.usuario = usuario;
    }
    
    
    @Override
    public boolean update(Usuario novo) {
         String sql = "UPDATE Usuarios " +
                    "SET matricula = ? nome = ? departamento = ? cargo = ? " +
                    "WHERE matricula = ? nome = ? departamento = ? cargo = ?";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, novo.getMatricula());
            stmt.setString(2, novo.getNome());
            stmt.setInt(3, novo.getDepartamento());
            stmt.setString(4, novo.getCargo());
            
            stmt.setInt(5, this.usuario.getMatricula());
            stmt.setString(6, this.usuario.getNome());
            stmt.setInt(7, this.usuario.getDepartamento());
            stmt.setString(8, this.usuario.getCargo());            

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
    public boolean delete() {
        String sql = "DELETE FROM Usuarios " +
                    "WHERE matricula = ? " +
                    "nome = ?" +
                    "departamento = ?" +
                    "cargo = ?";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, this.usuario.getMatricula());
            stmt.setString(2, this.usuario.getNome());
            stmt.setInt(3, this.usuario.getDepartamento());
            stmt.setString(4, this.usuario.getCargo());

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
    public boolean insert() {
        
        String sql = "INSERT INTO usuarios " +
                    "(matricula,nome,departamento,cargo)" +
                    " VALUES (?,?,?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, this.usuario.getMatricula());
            stmt.setString(2, this.usuario.getNome());
            stmt.setInt(3, this.usuario.getDepartamento());
            stmt.setString(4, this.usuario.getCargo());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }  
    
    public Usuario getByMatricula(int matricula) {
        String sql = "SELECT * " +
                    "FROM Usuarios " +
                    "WHERE matricula = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, matricula);
            return this.getByPreparedStatement(stmt);
        }
        catch(Exception e) {
            
        }
        return new Usuario();
    }

    public ArrayList<Usuario> getAllByDepartamento(int departamento) {
        String sql = "SELECT * FROM Usuarios WHERE departamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, departamento);
            return this.getListByPreparedStatement(stmt);
        }
        catch(Exception e) {
            
        }
        return new ArrayList<>();
    }
    
    
    public ArrayList<Usuario> getAll() {
        String sql = "SELECT * FROM Usuarios";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return this.getListByPreparedStatement(stmt);
        }
        catch(Exception e) {
            
        }
        return new ArrayList<>();
    }
    
         
    @Override
    public ArrayList<Usuario> getListByPreparedStatement( PreparedStatement s ) {
        
        ArrayList<Usuario> users = new ArrayList<>();
        try {

            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                users.add( this.byResultSet(rs) );
            }            
            s.close();
        }
        catch(Exception e) { 
            
        }
        return users;
    }
    
    @Override
    public Usuario getByPreparedStatement( PreparedStatement s ) {
        try {
            ResultSet rs = s.executeQuery();
            
            if(!rs.next())
                throw new RuntimeException("Usuario não encontrado!");
            
            Usuario u = this.byResultSet(rs);
            
            s.close();
            return u;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }        
    }
    
    public Usuario byResultSet(ResultSet user) {
        Usuario u = new Usuario();
        try {
            u.setNome( user.getString("nome") );
            u.setCargo( user.getString("cargo") );
            u.setDepartamento( user.getInt("departamento") );
            u.setMatricula( user.getInt("matricula") );
        }
        catch(Exception e) {
            
        }
        return u;
    }
}