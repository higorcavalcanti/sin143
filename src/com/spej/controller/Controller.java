package com.spej.controller;

public abstract class Controller<T> {
    
    public abstract boolean update(T novo);
    public abstract boolean delete();
    public abstract boolean insert(T novo);
}
