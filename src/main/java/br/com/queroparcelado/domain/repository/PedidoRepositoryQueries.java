package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.produto.Pedido;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepositoryQueries {

    List<Pedido> filtrarPorTaxaAdministrativa(BigDecimal taxaInicial, BigDecimal taxaFinal);
}
