package com.spej.dao;

import com.spej.model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao() {
        super();
    }    
    
    private String getStringUsuario() {
        return " matricula = ? nome = ? departamento = ? cargo = ? ";
    }
    
    @Override
    public boolean update(Usuario antigo, Usuario novo) {
        String sql = "UPDATE Usuarios " +
                    "SET " + this.getStringUsuario() + "" +
                    "WHERE " + this.getStringUsuario() + "";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, novo.getMatricula());
            stmt.setString(2, novo.getNome());
            stmt.setInt(3, novo.getDepartamento());
            stmt.setString(4, novo.getCargo());
            
            stmt.setInt(5, antigo.getMatricula());
            stmt.setString(6, antigo.getNome());
            stmt.setInt(7, antigo.getDepartamento());
            stmt.setString(8, antigo.getCargo());            

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
    public boolean delete(Usuario deletar) {
        String sql = "DELETE FROM Usuarios " +
                    "WHERE " + this.getStringUsuario() + "";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getMatricula());
            stmt.setString(2, deletar.getNome());
            stmt.setInt(3, deletar.getDepartamento());
            stmt.setString(4, deletar.getCargo());

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
    public boolean insert(Usuario novo) {
        
        String sql = "INSERT INTO usuarios " +
                    "(matricula,nome,departamento,cargo)" +
                    " VALUES (?,?,?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, novo.getMatricula());
            stmt.setString(2, novo.getNome());
            stmt.setInt(3, novo.getDepartamento());
            stmt.setString(4, novo.getCargo());

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
                    "WHERE matricula = ? " +
                    "LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, matricula);
            return this.getByPreparedStatement(stmt);
        }
        catch(Exception e) {
            
        }
        //return new Usuario();
        return null;
    }

    
    public Usuario getByUsuarioSenha(String usuario, String senha) {
        String sql = "SELECT * " +
                "FROM Usuarios " +
                "WHERE username = ? AND password = ? " + 
                "LIMIT 1";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            return this.getByPreparedStatement(stmt);
        }
        catch(Exception e) {

        }
        return null;
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
    
    
    @Override
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