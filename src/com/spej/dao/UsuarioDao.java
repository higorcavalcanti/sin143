package com.spej.dao;

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

    /**
     * Procura todos usuarios com o nome (like)
     * @param name Nome a procurar
     * @return Lista de usuários encontrados
     */
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
    
    /**
     * Obtem todos usuários para o relatório
     * @param d Departamento para filtrar (null para todos)
     * @return ResultSet contendo os usuários
     */
    public ResultSet relatorioUsuarios( Departamento d ) {
        String sql;
        
        try {
            sql = "SELECT u.matricula as usuarios_matricula, u.nome as usuarios_nome, u.cargo as usuarios_cargo, " +
                    "u.departamento as usuarios_departamento, d.nome as departamentos_nome " +
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

    /**
     * Gera SQL para o relatório
     * @param users Lista de Usuários
     * @param deps Lista de Departamentos
     * @return String do SQL
     */
    private String getSQLrelatorio(List<Usuario> users, List<Departamento> deps) {
        
        String sql = "";
        
        //sql +=  "SELECT *, SUBTIME(saida,entrada) as soma ";
        sql += "SELECT *, ROUND(time_to_sec((TIMEDIFF(saida, entrada))) / 60 / 60) as soma ";
        
        sql +=  "FROM Usuarios u " +
                "JOIN Ponto p ON p.usuario_matricula = u.matricula " +
                "JOIN Atividade a ON a.ponto_id = p.id ";
        
        sql +=  "WHERE u.matricula IN ( ";        
        for( int i=0; i < users.size(); i++ ) {
            if( i > 0 ) sql += ",";
            sql += users.get(i).getMatricula();
        }
        sql += ") ";
        
        sql +=  "AND u.departamento IN ( ";
        for( int i=0; i < deps.size(); i++ ) {
            if( i > 0 ) sql += ",";
            sql += deps.get(i).getId();
        }
        sql +=  ") ";
        
        sql +=  "AND p.entrada >= ? AND p.saida < ? + interval 1 day ";
        
        //sql +=  "GROUP BY u.matricula, p.id ";
        
        sql +=  "ORDER BY u.nome ";
        
        return sql;
    }
    
    
    /**
     * 
     * @param users usuarios que estarão no relatório
     * @param deps departamentos que estarão no relatório
     * @param inicio data de inicio do relatório
     * @param fim data de fim do relatório
     * @return Resultset contendo os dados para o Jasper
     */
    public ResultSet relatorioPonto( List<Usuario> users, List<Departamento> deps, Date inicio, Date fim ) {
        
        try {                       
                        
            stmt = connection.prepareStatement( this.getSQLrelatorio(users, deps) );           
            stmt.setDate(1, inicio);
            stmt.setDate(2, fim);
                                    
            return stmt.executeQuery();
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage() +".");
        }        
    }    
           
}