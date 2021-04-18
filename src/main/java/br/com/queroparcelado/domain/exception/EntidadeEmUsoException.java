package br.com.queroparcelado.domain.exception;

public class EntidadeEmUsoException extends RuntimeException {

    public EntidadeEmUsoException(String message, Throwable cause) {
        super(message, cause);
    }
}
