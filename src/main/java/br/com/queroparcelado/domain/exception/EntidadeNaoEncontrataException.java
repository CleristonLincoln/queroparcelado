package br.com.queroparcelado.domain.exception;

public class EntidadeNaoEncontrataException extends RuntimeException {

    public EntidadeNaoEncontrataException(String mensagem) {
        super(mensagem);
    }
}
