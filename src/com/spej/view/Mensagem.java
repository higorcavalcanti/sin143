package com.spej.view;

import java.awt.Component;
import javax.swing.JOptionPane;


public class Mensagem {
    
    public static void erro(Component c, Object message) {
        Mensagem.erro(c, message, "Erro!");
    }       
    public static void erro(Component c, Object message, String titulo) {
        JOptionPane.showMessageDialog(c, message, titulo, JOptionPane.ERROR_MESSAGE);
    }
    
        
    public static void sucesso(Component c, Object message) {
        Mensagem.sucesso(c, message, "Sucesso!");
    }        
    public static void sucesso(Component c, Object message, String titulo) {
        JOptionPane.showMessageDialog(c, message, titulo, JOptionPane.INFORMATION_MESSAGE);
    }
    
    
    public static void aviso(Component c, Object message) {
        Mensagem.aviso(c, message, "Aviso");
    }
    public static void aviso(Component c, Object message, String titulo) {
        JOptionPane.showMessageDialog(c, message, titulo, JOptionPane.WARNING_MESSAGE);
    }
}
