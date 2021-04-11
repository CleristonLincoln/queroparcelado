package br.com.queroparcelado.domain.model.dto;

import br.com.queroparcelado.domain.model.produto.Parcela;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

@Getter
@Setter
@Builder
public class RecebimentosDTO {

    private List<Parcela> parcelas;
    private BigDecimal totalAReceber;
    private BigInteger qtdTotalRecebimentos;

}
