package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.produto.Parcela;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface ParcelaRepository extends CustomJpaRepository<Parcela, Long>{

    @Query("SELECT SUM(p.valor) FROM Parcela p WHERE p.pedido.id = :idPedido")
    BigDecimal somaParcelas(Long idPedido);
}
