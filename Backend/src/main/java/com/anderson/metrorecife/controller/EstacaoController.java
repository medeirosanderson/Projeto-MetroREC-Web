package com.anderson.metrorecife.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anderson.metrorecife.exception.EstacaoNaoEncontradaException;
import com.anderson.metrorecife.model.Estacao;
import com.anderson.metrorecife.service.EstacaoService;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/estacoes")
public class EstacaoController {

    private final EstacaoService estacaoService;

    public EstacaoController(EstacaoService estacaoService) {
        this.estacaoService = estacaoService;
    }

    @GetMapping
    public List<Estacao> mostrarEstacoes(){
        return estacaoService.todasEstacoes();
    }

    @GetMapping("/linha")
    public List<Estacao> buscarLinha(@RequestParam String linha){
        return estacaoService.buscarLinha(linha);
    }

    @GetMapping("/estacao")
    public List<Estacao> buscarEstacao(@RequestParam String nome){
        return estacaoService.buscarEstacao(nome);
    }

    @GetMapping("/{id}")
    public Estacao buscarPorId(@PathVariable Integer id){
        return estacaoService.buscarPorId(id);
    }

    @ExceptionHandler(EstacaoNaoEncontradaException.class)
    public ResponseEntity<?> tratarEstacaoNaoEncontrada(EstacaoNaoEncontradaException exception) {
        Map <String, Object> resposta = new HashMap<>();
        resposta.put("erro", exception.getMessage());
        return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(resposta);
    }   
}


