package br.com.queroparcelado.api.exceptionHandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
    ENTIDADE_NAO_LEGIVEL("/entidade-nao-legivel", "Mensagem ilegível")
    ;

    private final String  title;
    private final String uri;

    ProblemType(String title, String uri) {
        this.title = "https://algafood.com.br" + title;
        this.uri = uri;
    }
}
