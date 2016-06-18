/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.event.ListDataListener;

import com.spej.dao.DepartamentoDao;

/**
 *
 * @author Higor
 */
public class DepartamentoComboBoxModel implements ComboBoxModel {
    
    private Departamento selected;
    private ArrayList<Departamento> departamentos;
    
    public DepartamentoComboBoxModel() {
        DepartamentoDao dao = new DepartamentoDao();
        this.departamentos = dao.getAll();
    }
    
    @Override
    public void setSelectedItem(Object anItem) {
        this.selected = (Departamento) anItem;
    }

    @Override
    public Departamento getSelectedItem() {
        return this.selected;
    }

    @Override
    public int getSize() {
        return this.departamentos.size();
    }

    @Override
    public Departamento getElementAt(int index) {
        return this.departamentos.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {
        
    }
}
