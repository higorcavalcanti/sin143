package com.spej.dao;

import com.spej.model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao() {
        super("usuarios");
    }    

    
    @Override
    public boolean insert(Usuario novo) {
        
        String sql = "INSERT INTO usuarios " +
                    "(matricula,nome,departamento,cargo,username,password,nascimento,email)" +
                    " VALUES (?,?,?,?,?,?,?,?)";
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
            stmt.setDate(7, novo.getNascimento());
            stmt.setString(8, novo.getEmail());

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
    public boolean update(Usuario antigo, Usuario novo) {
        String sql = "UPDATE Usuarios " +
                    "SET matricula = ?, nome = ?, departamento = ?, cargo = ?, " +
                        "username = ?, password = ?, nascimento = ?, email = ? " +
                    "WHERE matricula = ?";
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
            stmt.setDate(7, novo.getNascimento());
            stmt.setString(8, novo.getEmail());
            
            stmt.setInt(9, antigo.getMatricula());

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
                    "WHERE matricula = ?";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getMatricula());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
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
    public Usuario byResultSet(ResultSet user) {
        Usuario u = new Usuario();
        try {
            u.setNome( user.getString("nome") );
            u.setCargo( user.getString("cargo") );
            u.setDepartamento( user.getInt("departamento") );
            u.setMatricula( user.getInt("matricula") );
            u.setUsername( user.getString("username") );
            u.setPassword( user.getString("password") );
            u.setNascimento( user.getDate("nascimento") );
            u.setEmail( user.getString("email") );
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return u;
    }
}