/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import com.spej.dao.UsuarioDao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Higor
 */
public class UsuarioTableModel extends AbstractTableModel {

    private ArrayList<Usuario> users;
    
    public UsuarioTableModel(String nome) {
        this( new UsuarioDao().find(nome) );
    }   
    public UsuarioTableModel() {
        this( new UsuarioDao().getAll("matricula > 0") );
    }
    public UsuarioTableModel(ArrayList<Usuario> users) {
        super();
        this.users = users;
    }
    
    @Override
    public int getRowCount() {
        return this.users.size();
    }
    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            if(columnIndex == 0) return this.users.get(rowIndex).getMatricula();
            else if(columnIndex == 1) return this.users.get(rowIndex).getNome();
        } 
        catch(IndexOutOfBoundsException e) {            
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == 0) return "Matricula";
        else return "Nome";
    }
    
    
    @Override
    public boolean isCellEditable(int row, int col) { 
        return false; 
    }  
    
    public Usuario getRowObject(int rowIndex) {
        try {
            return this.users.get(rowIndex);
        } 
        catch(IndexOutOfBoundsException e) {            
        }
        return null;
    }
}
