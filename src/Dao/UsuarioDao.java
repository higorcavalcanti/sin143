package Dao;

import Model.Usuario;
import Persistencia.*;
import java.sql.*;

public class UsuarioDao {
    
    private Connection connection;  
    private Usuario usuario;

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioDao(Usuario usuario) {
        this.connection = ConnectionFactory.getConnection();
        this.usuario = usuario;
    }

    public boolean insert() {
        
        String sql = "insert into usuarios " +
                    "(matricula,nome,departamento,cargo)" +
                    " values (?,?,?,?)";
        try {
            // prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, this.usuario.getMatricula());
            stmt.setString(2, this.usuario.getNome());
            stmt.setInt(3, this.usuario.getDepartamento());
            stmt.setString(4, this.usuario.getCargo());

            // executa
            stmt.execute();
            stmt.close();
            return true;
        } 
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
}
