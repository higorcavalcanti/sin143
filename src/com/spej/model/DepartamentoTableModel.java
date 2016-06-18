/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import com.spej.dao.DepartamentoDao;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Higor
 */
public class DepartamentoTableModel extends AbstractTableModel {

    private ArrayList<Departamento> deps;
    
    public DepartamentoTableModel(String nome) {
        this( new DepartamentoDao().find(nome) );
    } 
    public DepartamentoTableModel() {
        this( new DepartamentoDao().getAll() );
    }
    public DepartamentoTableModel(ArrayList<Departamento> deps) {
        super();
        this.deps = deps;
    }
    
    @Override
    public int getRowCount() {
        return this.deps.size();
    }
    @Override
    public int getColumnCount() {
        return 1;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        try {
            //if(columnIndex == 0) return this.deps.get(rowIndex).getId();
            //else if(columnIndex == 1) return this.deps.get(rowIndex).getNome();
            return this.deps.get(rowIndex).getNome();
        } 
        catch(IndexOutOfBoundsException e) {            
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        //if(column == 0) return "ID";
        //else return "Nome";
        return "Nome";
    }
    
    
    @Override
    public boolean isCellEditable(int row, int col) { 
        return false; 
    }  
    
    public Departamento getRowObject(int rowIndex) {
        try {
            return this.deps.get(rowIndex);
        } 
        catch(IndexOutOfBoundsException e) {            
        }
        return null;
    }
}
