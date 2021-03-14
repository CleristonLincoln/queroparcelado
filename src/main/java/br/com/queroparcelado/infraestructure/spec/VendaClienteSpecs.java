package br.com.queroparcelado.infraestructure.spec;

import br.com.queroparcelado.domain.model.VendaCliente;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class VendaClienteSpecs {

    public static Specification<VendaCliente> valorAVista(){
        return ((root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("nParcelas"), BigDecimal.ZERO));
    }
}
