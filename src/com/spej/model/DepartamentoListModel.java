/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import com.spej.dao.DepartamentoDao;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Higor
 */
public class DepartamentoListModel extends AbstractListModel<Departamento> {

    private ArrayList<Departamento> deps;

    public DepartamentoListModel() {
        this.deps = new DepartamentoDao().getAll();
    }
    
    @Override
    public int getSize() {
        return this.deps.size();
    }

    @Override
    public Departamento getElementAt(int index) {
        return this.deps.get(index);
    }

}
