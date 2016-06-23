package com.spej.dao;

import com.spej.model.Atividade;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AtividadeDao extends Dao<Atividade> {
    
    public AtividadeDao() {
        super("Atividade");
    }
    
    @Override
    public boolean insert(Atividade novo) {
                
        String sql = "INSERT INTO Atividade " +
                    "(ponto_id,relatorio)" +
                    " VALUES (?,?)";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, novo.getPonto_id());
            stmt.setString(2, novo.getRelatorio());
            //stmt.setString(3, novo.getObservacao());

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
    public boolean update(Atividade antigo, Atividade novo) {
        String sql = "UPDATE Atividade " +
                    "SET id = ?, ponto_id = ?, relatorio = ?, observacao = ? " +
                    "WHERE id = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, novo.getId());
            stmt.setInt(2, novo.getPonto_id());
            stmt.setString(3, novo.getRelatorio());
            stmt.setString(4, novo.getObservacao());
            
            stmt.setInt(5, antigo.getId());

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
    public boolean delete(Atividade deletar) {
       String sql = "DELETE FROM Atividade " +
                    "WHERE id = ?";
        try {
            // prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            
            // seta os valores
            stmt.setInt(1, deletar.getId());

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
    public Atividade byResultSet(ResultSet user) {
        Atividade a = new Atividade();
        try {
            a.setId( user.getInt("id") );
            a.setPonto_id(user.getInt("ponto_id") );
            a.setRelatorio(user.getString("relatorio") );
            a.setObservacao(user.getString("observacao") );
        }
        catch(SQLException e) {
            throw new RuntimeException("Erro desconhecido!\nMensagem:\n" + e.getMessage());
        }
        return a;
    }
    
}
