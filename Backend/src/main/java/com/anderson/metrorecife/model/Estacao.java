package com.anderson.metrorecife.model;

public class Estacao {
    private int id;
    private String nome;
    private String linha;

    

    public Estacao(int id, String nome, String linha) {
        this.id = id;
        this.nome = nome;
        this.linha = linha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLinha() {
        return linha;
    }

    public void setLinha(String linha) {
        this.linha = linha;
    }

    
}
