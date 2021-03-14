package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.VendaCliente;

import java.math.BigDecimal;
import java.util.List;

public interface VendaClienteRepositoryQueries {

    List<VendaCliente> filtrarPorTaxa(BigDecimal taxaInicial, BigDecimal taxaFinal);
}
