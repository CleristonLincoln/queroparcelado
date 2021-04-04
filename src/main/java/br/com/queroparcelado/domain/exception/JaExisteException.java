package br.com.queroparcelado.domain.exception;

public class JaExisteException extends NegocioException{

    public JaExisteException(String message, Throwable cause) {
        super(message, cause);
    }

    public JaExisteException(String message) {
        super(message);
    }
}
