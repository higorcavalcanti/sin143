package Dao;

import Model.Usuario;
import java.sql.*;

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
            
            System.out.println("Inserido!");
            
            return true;
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }  
}