package com.anderson.metrorecife.service;

import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.model.Trecho;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TrechoService {

    private final List<Trecho> trechos = new ArrayList<>();

    public TrechoService(EstacaoService estacaoService) {

        Estacao recife = estacaoService.buscarPorId(1);
        Estacao joanaBezerra = estacaoService.buscarPorId(2);
        Estacao afogados = estacaoService.buscarPorId(3);
        Estacao ipiranga = estacaoService.buscarPorId(4);
        Estacao mangueira = estacaoService.buscarPorId(5);
        Estacao santaLuzia = estacaoService.buscarPorId(6);
        Estacao werneck = estacaoService.buscarPorId(7);
        Estacao barro = estacaoService.buscarPorId(8);
        Estacao tejipio = estacaoService.buscarPorId(9);
        Estacao coqueiral = estacaoService.buscarPorId(10);
        Estacao altoDoCeu = estacaoService.buscarPorId(11);
        Estacao curado = estacaoService.buscarPorId(12);
        Estacao rodoviaria = estacaoService.buscarPorId(13);
        Estacao cosmeEDamiao = estacaoService.buscarPorId(14);
        Estacao camaragibe = estacaoService.buscarPorId(15);
        
        Estacao cavaleiro = estacaoService.buscarPorId(16);
        Estacao floriano = estacaoService.buscarPorId(17);
        Estacao engenhoVelho = estacaoService.buscarPorId(18);
        Estacao jaboatao = estacaoService.buscarPorId(19);

        adicionarTrecho(recife, joanaBezerra, 1.5);
        adicionarTrecho(joanaBezerra, afogados, 1.8);
        adicionarTrecho(afogados, ipiranga, 1.2);
        adicionarTrecho(ipiranga, mangueira, 1.1);
        adicionarTrecho(mangueira, santaLuzia, 1.0);
        adicionarTrecho(santaLuzia, werneck, 1.2);
        adicionarTrecho(werneck, barro, 1.5);
        adicionarTrecho(barro, tejipio, 1.4);
        adicionarTrecho(tejipio, coqueiral, 1.3);
        adicionarTrecho(coqueiral, altoDoCeu, 2.0);
        adicionarTrecho(altoDoCeu, curado, 1.5);
        adicionarTrecho(curado, rodoviaria, 1.2);
        adicionarTrecho(rodoviaria, cosmeEDamiao, 1.4);
        adicionarTrecho(cosmeEDamiao, camaragibe, 2.0);

        adicionarTrecho(coqueiral, cavaleiro, 1.0);
        adicionarTrecho(cavaleiro, floriano, 2.7);
        adicionarTrecho(floriano, engenhoVelho, 1.3);
        adicionarTrecho(engenhoVelho, jaboatao, 1.4);
    }

    private void adicionarTrecho(Estacao origem, Estacao destino, double distancia){
        trechos.add(new Trecho(origem, destino, distancia));
    }

    public List<Trecho> buscarTrechosDaEstacao(Estacao estacao) {
        return trechos.stream()
                .filter(trecho ->
                        trecho.getOrigem().getId() == estacao.getId()
                                || trecho.getDestino().getId() == estacao.getId()
                )
                .toList();
    }

    public List<Trecho> todosTrechos() {
        return trechos;
    }

    public Trecho buscarTrecho(Estacao origem, Estacao destino) {
    return trechos.stream()
            .filter(trecho ->
                    (trecho.getOrigem().getId() == origem.getId()
                    && trecho.getDestino().getId() == destino.getId())

                    ||

                    (trecho.getOrigem().getId() == destino.getId()
                    && trecho.getDestino().getId() == origem.getId())
            )
            .findFirst()
            .orElse(null);
    }
}