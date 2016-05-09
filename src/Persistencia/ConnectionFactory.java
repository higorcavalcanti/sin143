package Persistencia;

import java.sql.*;

public class ConnectionFactory {
    
    private static String file = "bd.db";
    private static Connection conection = null;

    public static Connection getConnection() {
        //Se a conexão for nula
        if(ConnectionFactory.conection == null) {
            //Abre uma nova conexão
            try {
                Class.forName("org.sqlite.JDBC");
                ConnectionFactory.conection = DriverManager.getConnection("jdbc:sqlite:" + ConnectionFactory.file, "", "pass" );
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
    
    public static boolean closeConnection() {
        try {
            ConnectionFactory.conection.close();
            return true;
        }
        catch(Exception e) {
            return false;   
        }
    }
}
