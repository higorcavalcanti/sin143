/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.model;

import com.spej.dao.UsuarioDao;
import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Higor
 */
public class UsuarioListModel extends AbstractListModel {

    private ArrayList<Usuario> users;

    public UsuarioListModel() {
        this.users = new UsuarioDao().getAll();
    }
    
    @Override
    public int getSize() {
        return this.users.size();
    }

    @Override
    public Object getElementAt(int index) {
        return this.users.get(index);
    }

}
