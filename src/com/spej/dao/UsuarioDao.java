package com.spej.dao;

import com.spej.model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao() {
        super();
    }    
    
    private String getStringUsuario() {
        return " matricula = ? nome = ? departamento = ? cargo = ? username = ? password = ? ";
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
            stmt.setString(5, novo.getUsername());
            stmt.setString(6, novo.getPassword());
            
            stmt.setInt(7, antigo.getMatricula());
            stmt.setString(8, antigo.getNome());
            stmt.setInt(9, antigo.getDepartamento());
            stmt.setString(10, antigo.getCargo());
            stmt.setString(11, antigo.getUsername());
            stmt.setString(12, antigo.getPassword());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }
        catch(SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Já existe um usuário com essa matricula!");
        }        
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
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
            stmt.setString(5, deletar.getUsername());
            stmt.setString(6, deletar.getPassword());

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
    public boolean insert(Usuario novo) {
        
        String sql = "INSERT INTO usuarios " +
                    "(matricula,nome,departamento,cargo,username,password)" +
                    " VALUES (?,?,?,?,?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, novo.getMatricula());
            stmt.setString(2, novo.getNome());
            stmt.setInt(3, novo.getDepartamento());
            stmt.setString(4, novo.getCargo());
            stmt.setString(5, novo.getUsername());
            stmt.setString(6, novo.getPassword());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        } 
        catch(SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Já existe um usuário com essa matricula!");
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
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
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
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
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }

    
    public ArrayList<Usuario> getAllByDepartamento(int departamento) {
        String sql = "SELECT * FROM Usuarios WHERE departamento = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, departamento);
            return this.getListByPreparedStatement(stmt);
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }
    
    
    @Override
    public ArrayList<Usuario> getAll() {
        String sql = "SELECT * FROM Usuarios";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            return this.getListByPreparedStatement(stmt);
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());   
        }
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
        catch(SQLException e) { 
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
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
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }        
    }
    
    @Override
    public Usuario byResultSet(ResultSet user) {
        Usuario u = new Usuario();
        try {
            u.setNome( user.getString("nome") );
            u.setCargo( user.getString("cargo") );
            u.setDepartamento( user.getInt("departamento") );
            u.setMatricula( user.getInt("matricula") );
            u.setUsername( user.getString("username") );
            u.setPassword( user.getString("password") );
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return u;
    }
}