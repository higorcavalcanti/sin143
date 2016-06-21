package com.spej.persistencia;

import java.sql.*;

/**
 * Classe que inicializa a conexão com o banco de dados
 */
public class ConnectionFactory {

    private static final String dbhost = "localhost";
    private static final String dbuser = "root";
    private static final String dbpass = "";
    private static final String dbname = "spej";
    private static final String dbopts = "zeroDateTimeBehavior=convertToNull";
    private static final String URL = "jdbc:mysql://" + dbhost + "/" + dbname + "?" + dbopts;
    
    //private static String file = "bd.db";
    
    private static Connection conection = null;

    /**
     * Cria ou retorna a conexão ativa com o banco
     * @return Conexão ativa com o banco
     */
    public static Connection getConnection() {
        return getConnectionMysql(); 
    }
    
    
    /**
     * Cria ou retorna a conexão ativa com o banco MySQL
     * @return Conexão ativa com o banco de dados MySQL
     */
    private static Connection getConnectionMysql() {
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
