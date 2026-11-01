package com.anderson.metrorecife.service;

import com.anderson.metrorecife.exception.EstacaoNaoEncontradaException;
import com.anderson.metrorecife.model.Estacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class EstacaoService {

    private final List<Estacao> linhaCentro = new ArrayList<>();
    private final List<Estacao> linhaSul = new ArrayList<>();

    private final List<Estacao> estacoes = new ArrayList<>();

    public EstacaoService() {

        // Linha Centro - trecho principal
        linhaCentro.add(new Estacao(1, "Recife", "Centro"));
        linhaCentro.add(new Estacao(2, "Joana Bezerra", "Centro"));
        linhaCentro.add(new Estacao(3, "Afogados", "Centro"));
        linhaCentro.add(new Estacao(4, "Ipiranga", "Centro"));
        linhaCentro.add(new Estacao(5, "Mangueira", "Centro"));
        linhaCentro.add(new Estacao(6, "Santa Luzia", "Centro"));
        linhaCentro.add(new Estacao(7, "Werneck", "Centro"));
        linhaCentro.add(new Estacao(8, "Barro", "Centro"));
        linhaCentro.add(new Estacao(9, "Tejipió", "Centro"));
        linhaCentro.add(new Estacao(10, "Coqueiral", "Centro"));

        // Ramal Camaragibe
        linhaCentro.add(new Estacao(11, "Alto do Céu", "Centro"));
        linhaCentro.add(new Estacao(12, "Curado", "Centro"));
        linhaCentro.add(new Estacao(13, "Rodoviária", "Centro"));
        linhaCentro.add(new Estacao(14, "Cosme e Damião", "Centro"));
        linhaCentro.add(new Estacao(15, "Camaragibe", "Centro"));

        // Ramal Jaboatão
        linhaCentro.add(new Estacao(16, "Cavaleiro", "Centro"));
        linhaCentro.add(new Estacao(17, "Floriano", "Centro"));
        linhaCentro.add(new Estacao(18, "Engenho Velho", "Centro"));
        linhaCentro.add(new Estacao(19, "Jaboatão", "Centro"));

        // Linha Sul
        linhaSul.add(new Estacao(20, "Largo da Paz", "Sul"));
        linhaSul.add(new Estacao(21, "Imbiribeira", "Sul"));
        linhaSul.add(new Estacao(22, "Antônio Falcão", "Sul"));
        linhaSul.add(new Estacao(23, "Shopping", "Sul"));
        linhaSul.add(new Estacao(24, "Tancredo Neves", "Sul"));
        linhaSul.add(new Estacao(25, "Aeroporto", "Sul"));
        linhaSul.add(new Estacao(26, "Porta Larga", "Sul"));
        linhaSul.add(new Estacao(27, "Monte dos Guararapes", "Sul"));
        linhaSul.add(new Estacao(28, "Prazeres", "Sul"));
        linhaSul.add(new Estacao(29, "Cajueiro Seco", "Sul"));

        // Junta todas as estações
        estacoes.addAll(linhaCentro);
        estacoes.addAll(linhaSul);
    }

    public List<Estacao> todasEstacoes() {
        return estacoes;
    }

    public List<Estacao> buscarLinha(String linha) {
        return estacoes.stream()
                .filter(estacao -> estacao.getLinha()
                        .toLowerCase()
                        .contains(linha.toLowerCase()))
                .toList();
    }

    public List<Estacao> buscarEstacao(String nome) {
        return estacoes.stream()
                .filter(estacao -> estacao.getNome()
                        .toLowerCase()
                        .contains(nome.toLowerCase()))
                .collect(Collectors.toList());
    }

    public Estacao buscarPorId(Integer id) {
        Optional<Estacao> buscarId = estacoes.stream()
                .filter(estacao -> estacao.getId() == id)
                .findFirst();

        return buscarId.orElseThrow(
                () -> new EstacaoNaoEncontradaException(
                        "Estação com ID: " + id + " não encontrada."
                )
        );
    }
}