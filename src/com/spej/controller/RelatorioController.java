/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spej.controller;

import com.spej.dao.UsuarioDao;
import com.spej.model.Departamento;
import com.spej.model.Usuario;
import com.spej.view.Mensagem;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 * Controller dos relatórios
 */
public class RelatorioController {
    
    public static enum Relatorios {	
	ATIVIDADE(1),
        PRESENCA(2),
        COMPLETO(3);
        
	private final int valor;
	Relatorios(int valorOpcao){
            valor = valorOpcao;
	}
    }

    private UsuarioDao ud;
    
    public RelatorioController() {
        ud = new UsuarioDao();
    }

    
    public JasperViewer relatorioUsuarios( Departamento selected ) {
        
        try {       
            
            JRResultSetDataSource relResult = new JRResultSetDataSource( ud.relatorioUsuarios(selected) );
            JasperPrint jpPrint = JasperFillManager.fillReport("iReports/RelatorioUsuario.jasper", new HashMap(), relResult);
            return new JasperViewer(jpPrint, false);        
        } 
        catch(Exception e) {
            Mensagem.erro(null, "Falha ao abrir relatório!\n" + e.getMessage());
        }
        return null;
    }
    
    /**
     * 
     * @param relatorio
     * @param user
     * @param deps
     * @param inicio
     * @param fim
     * @return 
     */
    public JasperViewer relatorio(Relatorios relatorio, List<Usuario> user, List<Departamento> deps, Date inicio, Date fim) {
        
        ResultSet rs = ud.relatorioPonto(user, deps, inicio, fim);
        
        try {                   
            JRResultSetDataSource relResult = new JRResultSetDataSource( rs );
            JasperPrint jpPrint;
            
            if(relatorio == Relatorios.ATIVIDADE) {
                jpPrint = JasperFillManager.fillReport("iReports/RelatorioAtividades.jasper", new HashMap(), relResult);
            }
            else if(relatorio == Relatorios.PRESENCA) {
                jpPrint = JasperFillManager.fillReport("iReports/RelatorioDePresencas.jasper", new HashMap(), relResult);
            } 
            else {
                jpPrint = JasperFillManager.fillReport("iReports/RelatorioCompleto.jasper", new HashMap(), relResult);
            }
            return new JasperViewer(jpPrint, false);        
        } 
        catch(Exception e) {
            Mensagem.erro(null, "Falha ao abrir relatório!\n" + e.getMessage());
        }
        return null;           
    }
}
