/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.controller;

import com.spej.dao.UsuarioDao;
import com.spej.view.Mensagem;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Higor
 */
public class RelatorioController {
    
    public JasperViewer relatorioUsuarios() {
        
        try {        
            UsuarioDao ud = new UsuarioDao();
            
            JRResultSetDataSource relResult = new JRResultSetDataSource( ud.relatorioTodos() );
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/relatorioUsuarios.jasper", new HashMap(), relResult);
            return new JasperViewer(jpPrint, false);        
        } 
        catch(Exception e) {
            Mensagem.erro(null, "Falha ao abrir relatório!\n" + e.getMessage());
        }
        return null;
    }
            
    /*
    Departamento d = (Departamento) jComboDepartamento.getSelectedItem();

    if(d != null) { //Selecionou um departamento

    } //Nenhum departamento selecionado
    else {

    }
    */
}
