/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import com.spej.dao.PontoDao;
import com.spej.dao.UsuarioDao;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Higor
 */
public class PontoTableModel extends AbstractTableModel {

    private ArrayList<Ponto> pontos;
    
    public PontoTableModel() {
        this( new PontoDao().getAll("WHERE saida IS NULL") );
    }
    public PontoTableModel(ArrayList<Ponto> pontos) {
        super();
        this.pontos = pontos;
    }
    
    @Override
    public int getRowCount() {
        return this.pontos.size();
    }
    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        
        SimpleDateFormat dia = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat hora = new SimpleDateFormat("HH:mm:ss");
        
        try {
            UsuarioDao ud = new UsuarioDao();
            if(columnIndex == 0) {                
                return ud.getByMatricula( this.pontos.get(rowIndex).getUsuarioMatricula()).getMatricula();
            }
            else if(columnIndex == 1) {                
                return ud.getByMatricula( this.pontos.get(rowIndex).getUsuarioMatricula() ).getNome();
            }
            else if(columnIndex == 2) {
                return dia.format( 
                    this.pontos.get(rowIndex).getEntrada() 
                ) + " às " + 
                hora.format(
                    this.pontos.get(rowIndex).getEntrada() 
                );
            }
        } 
        catch(IndexOutOfBoundsException e) {            
        }
        return "";
    }
    
    @Override
    public String getColumnName(int column) {
        if(column == 0) return "Matricula";
        else if(column == 1) return "Nome";
        else return "Horário de entrada";
    }
    
    @Override
    public boolean isCellEditable(int row, int col) { 
        return false; 
    }    
}
