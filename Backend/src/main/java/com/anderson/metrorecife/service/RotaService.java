package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.model.Rota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RotaService {

    private final EstacaoService estacaoService;
    private final CalculadoraRota calculadoraRota;

    public RotaService(EstacaoService estacaoService,
        TrechoService trechoService) {

        this.estacaoService = estacaoService;
        this.calculadoraRota = new CalculadoraRota(trechoService.todosTrechos());
    }

    public double calcularDistancia(Integer origemId, Integer destinoId) {

        Estacao origem = estacaoService.buscarPorId(origemId);
        Estacao destino = estacaoService.buscarPorId(destinoId);

        return calculadoraRota.calcularDistancia(origem, destino);
    }

    public double calcularTempo(Integer origemId, Integer destinoId){
        Estacao origem = estacaoService.buscarPorId(origemId);
        Estacao destino = estacaoService.buscarPorId(destinoId);

        return calculadoraRota.calcularTempoMinutos(origem, destino);
    }

    public Rota calcularRota(Integer origemId, Integer destinoId){
        Estacao origem = estacaoService.buscarPorId(origemId);
        Estacao destino = estacaoService.buscarPorId(destinoId);
        double distancia = calculadoraRota.calcularDistancia(origem, destino);
        long tempo = calculadoraRota.calcularTempoMinutos(origem, destino);
        List<Estacao> caminho = calculadoraRota.calcularCaminho(origem, destino);

        return new Rota(origem, destino, caminho, distancia, tempo);
    }
}
