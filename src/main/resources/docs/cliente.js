function consultarRestaurantes() {
    $.ajax({
        url: "http://queroparcelado.web:8080/cliente",
        type: "get",

        success: function(response) {
            $("#conteudo").text(response);
        }
    });
}

$("#botao").click(consultarRestaurantes);