package br.com.queroparcelado.domain.model.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PedidoDTO {

    private BigDecimal valorProposta;
    private BigDecimal qtdParcela;

    private String banco;
    private String agencia;
    private String conta;

    private String endereco;
    private String numero;
    private String bairro;
    private String cep;
    private String cidade;

    private Long formaRecebimento;
    private Long formaParcelamento;
    private Long idCliente;

}
