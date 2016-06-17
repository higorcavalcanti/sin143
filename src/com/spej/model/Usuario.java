package com.spej.model;

import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Date;
import java.sql.Timestamp;

/**
 *
 * @author Higor
 */
public class Usuario {
    
    private int matricula;
    private String nome;
    private int departamento;
    private String cargo;
    private String username;
    private String password;
    private Date nascimento;
    private String email;
    
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
 
    @Override
    public String toString() {
        return "[" + this.getMatricula() + "]" + this.getNome();
    }
}
