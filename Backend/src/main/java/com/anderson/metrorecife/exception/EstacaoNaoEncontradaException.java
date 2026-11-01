package com.anderson.metrorecife.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EstacaoNaoEncontradaException extends RuntimeException {
    public EstacaoNaoEncontradaException(String mensagem){
        super(mensagem);
    }
}
