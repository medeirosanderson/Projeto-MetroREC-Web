package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.model.Trecho;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraRota {

    private List<Trecho> trechos;
    private static final double VELOCIDADE_MEDIA = 40.0;

    public CalculadoraRota(List<Trecho> trechos) {
        this.trechos = trechos;
    }

    private Estacao encontrarProximaEstacao(Trecho trecho, Estacao atual) {

        if (trecho.getOrigem().getId() == atual.getId()) {
            return trecho.getDestino();
        }

        return trecho.getOrigem();
    }

    public double calcularDistancia(Estacao origem, Estacao destino) {

        if (origem.getId() == destino.getId()) {
            return 0;
        }

        double distanciaTotal = 0;

        for (int i = 0; i < trechos.size(); i++) {

            Trecho trecho = trechos.get(i);

            if (trecho.getOrigem().getId() == origem.getId()) {

                for (int j = i; j < trechos.size(); j++) {

                    Trecho trechoAtual = trechos.get(j);
                    distanciaTotal += trechoAtual.getDistancia();

                    if (trechoAtual.getDestino().getId() == destino.getId()) {
                        return distanciaTotal;
                    }
                }
            }
        }

        distanciaTotal = 0;

        for (int i = trechos.size() - 1; i >= 0; i--) {

            Trecho trecho = trechos.get(i);

            if (trecho.getDestino().getId() == origem.getId()) {

                for (int j = i; j >= 0; j--) {

                    Trecho trechoAtual = trechos.get(j);
                    distanciaTotal += trechoAtual.getDistancia();

                    if (trechoAtual.getOrigem().getId() == destino.getId()) {
                        return distanciaTotal;
                    }
                }
            }
        }

        return 0;
    }

    public List<Estacao> calcularCaminho(Estacao origem, Estacao destino) {

        List<Estacao> caminho = new ArrayList<>();

        if (origem.getId() == destino.getId()) {
            return List.of(origem);
        }

        Estacao atual = origem;

        for (int i = 0; i < trechos.size(); i++) {

            Trecho trecho = trechos.get(i);

            if (trecho.getOrigem().getId() == origem.getId()) {

                caminho.add(trecho.getOrigem());

                for (int j = i; j < trechos.size(); j++) {

                    Trecho trechoAtual = trechos.get(j);

                    caminho.add(trechoAtual.getDestino());

                    if (trechoAtual.getDestino().getId() == destino.getId()) {
                        return caminho;
                    }
                }

                caminho.clear();
            }
        }

        for (int i = trechos.size() - 1; i >= 0; i--) {

            Trecho trecho = trechos.get(i);

            if (trecho.getDestino().getId() == origem.getId()) {

                caminho.add(trecho.getDestino());

                for (int j = i; j >= 0; j--) {

                    Trecho trechoAtual = trechos.get(j);

                    caminho.add(trechoAtual.getOrigem());

                    if (trechoAtual.getOrigem().getId() == destino.getId()) {
                        return caminho;
                    }
                }

                caminho.clear();
            }
        }

        return new ArrayList<>();
    }

    public long calcularTempoMinutos(Estacao origem, Estacao destino) {

        double distancia = calcularDistancia(origem, destino);

        double tempoHoras = distancia / VELOCIDADE_MEDIA;

        return Math.round(tempoHoras * 60);
    }
}