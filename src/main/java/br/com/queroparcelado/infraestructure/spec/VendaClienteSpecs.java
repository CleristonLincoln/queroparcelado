package br.com.queroparcelado.infraestructure.spec;

import br.com.queroparcelado.domain.model.produto.Pedido;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class VendaClienteSpecs {

    public static Specification<Pedido> valorAVista(){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("nParcelas"), BigDecimal.ZERO));
    }
}
