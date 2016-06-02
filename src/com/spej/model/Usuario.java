package com.spej.model;

/**
 *
 * @author Higor
 */
public class Usuario {
    
    private int matricula;
    private String nome;
    private int departamento;
    private String cargo;

    
    public Usuario() {
    }
    
    public Usuario(int matricula, String nome, int departamento, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.departamento = departamento;
        this.cargo = cargo;
    }

    public int getMatricula() {
        return matricula;
    }
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDepartamento() {
        return departamento;
    }
    public void setDepartamento(int departamento) {
        this.departamento = departamento;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
 
    @Override
    public String toString() {
        return "[" + this.getMatricula() + "]" + this.getNome();
    }
}
