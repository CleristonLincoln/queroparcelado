package br.com.queroparcelado.domain.model.dto;

import br.com.queroparcelado.domain.model.Configuracao;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class PedidoDTO {


    BigDecimal valor;
    Configuracao idParcelamento;

    FormaRecebimento formaRecebimento;

    String banco;
    String agencia;
    String conta;

    String cidade;
    String endereco;
    String numero;


}

@Data
class FormaRecebimento{
    Long id;
    String descricao;

}