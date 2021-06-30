package br.com.queroparcelado.domain.model.dto;

import lombok.Data;

@Data
public class ValidarClienteDTO {

    private String cpfCliente;
    private String senha;
}
