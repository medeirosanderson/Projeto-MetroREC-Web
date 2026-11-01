package com.anderson.metrorecife.model;
import java.util.List;

public class Rota{
    private Estacao origem;
    private Estacao destino;
    private List<Estacao> caminho;
    private double distanciaTotal;
    private long tempoEstimado;

    public Rota(Estacao origem, Estacao destino, List<Estacao> caminho, double distanciaTotal, long tempoEstimado) {
        this.origem = origem;
        this.destino = destino;
        this.caminho = caminho;
        this.distanciaTotal = distanciaTotal;
        this.tempoEstimado = tempoEstimado;
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
    public List<Estacao> getCaminho() {
        return caminho;
    }
    public void setCaminho(List<Estacao> caminho) {
        this.caminho = caminho;
    }
    public double getDistanciaTotal() {
        return distanciaTotal;
    }
    public void setDistanciaTotal(double distanciaTotal) {
        this.distanciaTotal = distanciaTotal;
    }
    public long getTempoEstimado() {
        return tempoEstimado;
    }
    public void setTempoEstimado(long tempoEstimado) {
        this.tempoEstimado = tempoEstimado;
    }

    
}