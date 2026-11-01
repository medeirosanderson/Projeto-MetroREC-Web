package com.anderson.metrorecife.model;

public class Trecho {

    private Estacao origem;
    private Estacao destino;
    private double distancia;

    public Trecho(Estacao origem, Estacao destino, double distancia) {
        this.origem = origem;
        this.destino = destino;
        this.distancia = distancia;
    }

    public Estacao getOrigem() {
        return origem;
    }

    public void setOrigem(Estacao origem) {
        this.origem = origem;
    }

    public Estacao getDestino() {
        return destino;
    }

    public void setDestino(Estacao destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }
}