package com.spej.controller;

public abstract class Controller<T> {
    
    public abstract boolean update(T antigo, T novo);
    public abstract boolean delete(T deletar);
    public abstract boolean insert(T novo);
    
    public abstract boolean update(T novo);
    public abstract boolean delete();
    public abstract boolean insert();
}
