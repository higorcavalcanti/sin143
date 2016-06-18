package com.spej.model;

import java.sql.Date;
import java.util.Objects;

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
    private boolean admin;
    
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

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
    
    @Override
    public boolean equals(Object other) {
        
        try {
            if (!(other instanceof Usuario))
                return false;

            if (other == this)
                return true;

            Usuario u = (Usuario) other;    

            return (                
                this.getMatricula() == u.getMatricula() &&
                this.getUsername().equals( u.getUsername() ) 
            );
        } catch(Exception e) {
            return false;
        }
    }    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.matricula;
        hash = 61 * hash + Objects.hashCode(this.username);
        hash = 61 * hash + Objects.hashCode(this.password);
        hash = 61 * hash + Objects.hashCode(this.email);
        hash = 61 * hash + (this.admin ? 1 : 0);
        return hash;
    }
 
    @Override
    public String toString() {
        return "[" + this.getMatricula() + "] " + this.getNome();
    }
}
