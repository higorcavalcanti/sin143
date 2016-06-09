package com.spej.persistencia;

import java.sql.*;

public class ConnectionFactory {
    
    private static final String dbhost = "localhost";
    private static final String dbuser = "root";
    private static final String dbpass = "";
    private static final String dbname = "sperj";
    private static final String URL = "jdbc:mysql://" + dbhost + "/" + dbname;
    
    //private static String file = "bd.db";
    private static Connection conection = null;

    public static Connection getConnection() {
        //Se a conexão for nula
        if(ConnectionFactory.conection == null) {
            //Abre uma nova conexão
            try {
                Class.forName("com.mysql.jdbc.Driver");
                ConnectionFactory.conection = DriverManager.getConnection(URL, dbuser, dbpass);
                return ConnectionFactory.conection;
            }
            catch(ClassNotFoundException | SQLException e) {
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
