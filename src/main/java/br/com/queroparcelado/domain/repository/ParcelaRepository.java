package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.produto.Parcela;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public interface ParcelaRepository extends CustomJpaRepository<Parcela, Long>{

    @Query("SELECT SUM(p.valor) FROM Parcela p WHERE p.pedido.id = :idPedido")
    BigDecimal somaParcelas(Long idPedido);


    List<Parcela> findParcelaByDataVencimentoBetween(LocalDate dataInicial, LocalDate dataFinal);
}
