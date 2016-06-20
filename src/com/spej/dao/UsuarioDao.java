package com.spej.dao;

import com.spej.controller.RelatorioController;
import com.spej.model.Departamento;
import com.spej.model.Usuario;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao extends Dao<Usuario> {

    public UsuarioDao() {
        super("usuarios");
    }    

    
    @Override
    public boolean insert(Usuario novo) {
        
        String sql = "INSERT INTO usuarios " +
                    "(matricula,nome,departamento,cargo,username,password,nascimento,email,admin)" +
                    " VALUES (?,?,?, ?,?,?, ?,?,?)";
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
            stmt.setBoolean(9, novo.isAdmin());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        } 
        catch(SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Já existe um usuário com algum desses dados! \nMensagem: \n" + e.getMessage());
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }  
    
    @Override
    public boolean update(Usuario antigo, Usuario novo) {
        String sql = "UPDATE Usuarios " +
                    "SET matricula = ?, nome = ?, departamento = ?, cargo = ?, " +
                        "username = ?, password = ?, nascimento = ?, email = ?, admin = ? " +
                    "WHERE matricula = ?";
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
            stmt.setBoolean(9, novo.isAdmin());
            
            stmt.setInt(10, antigo.getMatricula());

            // executa
            stmt.executeUpdate();
            stmt.close();
            
            return true;
        }
        catch(SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("Já existe um usuário com algum desses dados! \nMensagem:\n" + e.getMessage());
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
            stmt = connection.prepareStatement(sql);
            
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
            stmt = connection.prepareStatement(sql);
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
                "WHERE username = ? AND password = ?" + 
                "LIMIT 1";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, usuario);
            stmt.setString(2, senha);
            return this.getByPreparedStatement(stmt);
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
            u.setAdmin( user.getBoolean("admin") );
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return u;
    }
    
    
    @Override
    public ArrayList<Usuario> getAll() {
        return this.getAll("ORDER BY nome");
    }

        
    public ArrayList<Usuario> find(String name) {
        String sql = "SELECT * FROM Usuarios WHERE nome LIKE ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, "%" + name + "%");
            return this.getListByPreparedStatement(stmt);
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
    }    
    
    
    public ResultSet relatorioUsuarios( Departamento d ) {
        String sql;
        
        try {
            sql = "SELECT u.matricula, u.nome, u.cargo, d.nome as departamento "+
                    "FROM Usuarios u " +
                    "JOIN Departamentos d ON d.id = u.departamento ";
            stmt = connection.prepareStatement(sql);
            
            if(d != null) {
                sql += "WHERE d.id = ?";
                stmt = connection.prepareStatement(sql);
                stmt.setInt(1, d.getId());
            }
            
            return stmt.executeQuery();
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }        
    }
    
    
    
    
    
    /*
    private String getSQLrelatorio(RelatorioController.Relatorios relatorio, List<Usuario> users, List<Departamento> deps, Date inicio, Date fim) {
        String sql = "SELECT u.matricula as usuario_matricula, u.nome as usuario_nome, p.entrada as ponto_entrada, p.saida as ponto_saida "+
                    "FROM Usuarios u " +
                    "JOIN Ponto p ON p.usuario_matricula = u.matricula ";
            
        sql += "WHERE u.matricula IN (";

        int i = 0;
        for(Usuario u : users) {
            if(i != 0)
                sql += ",";
            sql += "" + u.getMatricula();
            i++;
        }

        sql += ") AND u.departamento IN (";
        i = 0;
        for(Departamento d : deps) {
            if(i != 0)
                sql += ",";
            sql += "" + d.getId();
            i++;
        }            
        sql += ")";    
        
        return sql;
    }
    */
    
    private String getSQLrelatorio(RelatorioController.Relatorios relatorio) {
        
        String sql = "SELECT u.matricula as usuario_matricula, u.nome as usuario_nome ";
        
        if(relatorio == RelatorioController.Relatorios.ATIVIDADE)
            sql += ", a.relatorio as atividade_relatorio ";
        else if(relatorio == RelatorioController.Relatorios.PRESENCA)
            sql += ", p.entrada as ponto_entrada, p.saida as ponto_saida ";
        else if(relatorio == RelatorioController.Relatorios.COMPLETO)
            sql += ", p.entrada as ponto_entrada, p.saida as ponto_saida, a.relatorio as atividade_relatorio ";
        
        sql +=  "FROM Usuarios u " +
                "JOIN Ponto p ON p.usuario_matricula = u.matricula " +
                "JOIN Atividade a ON a.ponto_id = p.id ";
        
        sql +=  "WHERE u.matricula IN (?) " +
                "AND u.departamento IN (?) " +
                "AND p.entrada > ? AND p.saida < ? ";
        
        sql +=  "ORDER BY u.nome ";
        
        return sql;
    }
    
    
    /**
     * 
     * @param relatorio tipo do relatório
     * @param users usuarios que estarão no relatório
     * @param deps departamentos que estarão no relatório
     * @param inicio data de inicio do relatório
     * @param fim data de fim do relatório
     * @return Resultset contendo os dados para o Jasper
     */
    public ResultSet relatorioPonto( RelatorioController.Relatorios relatorio, List<Usuario> users, List<Departamento> deps, Date inicio, Date fim ) {
        
        try {                       
            stmt = connection.prepareStatement( this.getSQLrelatorio(relatorio) );            
            
            stmt.setArray(1, null );
            stmt.setArray(2, null );
            stmt.setDate(3, inicio);
            stmt.setDate(4, fim);
            
            return stmt.executeQuery();
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }        
    }    
           
}