package com.spej.controller;

public abstract class Controller<T> {
    
    public abstract boolean update(T antigo, T novo) throws RuntimeException;
    public abstract boolean delete(T deletar) throws RuntimeException;
    public abstract boolean insert(T novo) throws RuntimeException;
    
    public abstract boolean update(T novo) throws RuntimeException;
    public abstract boolean delete() throws RuntimeException;
    public abstract boolean insert() throws RuntimeException;
}
