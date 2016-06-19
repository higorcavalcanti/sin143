package com.spej.model;

public class Atividade {
    
    private int id;
    private int ponto_id;
    private String relatorio;
    private String observacao;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPonto_id() {
        return ponto_id;
    }

    public void setPonto_id(int ponto_id) {
        this.ponto_id = ponto_id;
    }

    public String getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(String relatorio) {
        this.relatorio = relatorio;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
