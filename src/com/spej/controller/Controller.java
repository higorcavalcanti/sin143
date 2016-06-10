package com.spej.controller;

import com.spej.dao.Dao;
import java.util.ArrayList;

public abstract class Controller<T> {

    protected Dao dao;

    public Controller(Dao dao) {
        this.dao = dao;
    }
    
    public abstract Dao getDao();
    
    
    /**
     * Atualiza um item do banco
     * @param antigo item antigo (que será atualizado)
     * @param novo item novo (que será o novo)
     * @return true ou false
     * @throws RuntimeException
     */
    public boolean update(T antigo, T novo) throws RuntimeException
    {
        return this.dao.update(antigo, novo);
    }

    /**
     * Deleta um item do banco
     * @param deletar (Item a deletar)
     * @return
     * @throws RuntimeException
     */
    public boolean delete(T deletar) throws RuntimeException {
        return this.dao.delete(deletar);
    }

    /**
     * Insere um item no banco
     * @param novo Item a ser inserido
     * @return
     * @throws RuntimeException
     */
    public boolean insert(T novo) throws RuntimeException {
        return this.dao.insert(novo);
    }
    
    /**
     * Atualiza o item atual no banco
     * @param novo Novo item (substitui o atual)
     * @return
     * @throws RuntimeException
     */
    public boolean update(T novo) throws RuntimeException {
        return this.dao.update(novo, novo);
    }
    
    /**
     * Retorna todos itens do banco de dados
     * @return 
     */
    public ArrayList<T> getAll() {
        return this.dao.getAll();
    }    
}
