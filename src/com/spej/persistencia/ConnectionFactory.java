package com.spej.persistencia;

import com.spej.dao.UsuarioDao;
import com.spej.model.Usuario;
import java.sql.*;

public class ConnectionFactory {
    
    //private static String file = "bd.db";
    private static Connection conection = null;

    public static Connection getConnection() {
        //Se a conexão for nula
        if(ConnectionFactory.conection == null) {
            //Abre uma nova conexão
            try {
                Class.forName("org.h2.Driver");
                ConnectionFactory.conection = DriverManager.getConnection("jdbc:h2:./ponto", "sa", "");
                return ConnectionFactory.conection;
            }
            catch(Exception e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            }
            return null;
        } 
        else {
            //Se não for nula, retorna a conexão atual
            return ConnectionFactory.conection;
        }
    }
}
