package Dao;

import Model.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class UsuarioDao extends Dao {

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
        
        try {
            String sql = "SELECT * " +
                        "FROM Usuarios " +
                        "WHERE matricula = ? " +
                        "LIMIT 1";

            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, matricula);

            ResultSet rs = stmt.executeQuery();
            
            if(!rs.next())
                throw new RuntimeException("Usuario não encontrado!");
            
            Usuario u = new Usuario(
                    rs.getInt("matricula"),
                    rs.getString("nome"),
                    rs.getInt("departamento"),
                    rs.getString("cargo")
            );
            
            stmt.close();
            return u;
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    /*
    public Usuario getAll(int matricula) {
        
        try {
            String sql = "SELECT * " +
                        "FROM Usuarios";

            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            
            ArrayList<Usuario> users = new ArrayList<>();
                        
            while (rs.next()) {
                users.add(
                    new Usuario(
                        rs.getInt("matricula"),
                        rs.getString("nome"),
                        rs.getInt("departamento"),
                        rs.getString("cargo")
                    )
                );
            }
            
            stmt.close();
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
    */
}