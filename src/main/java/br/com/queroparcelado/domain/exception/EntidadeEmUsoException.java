package br.com.queroparcelado.domain.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntidadeEmUsoException extends ResponseStatusException {

    public EntidadeEmUsoException(HttpStatus status, String message) {
        super(status, message);
    }

    public EntidadeEmUsoException(String message) {
        this (HttpStatus.NOT_FOUND, message);
    }
}
