/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Persistencia.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Higor
 */
public class Dao {
    
    protected Connection connection;  
    protected PreparedStatement stmt;

    public Dao() {
        this.connection = ConnectionFactory.getConnection();
        this.stmt = null;
    }
}
