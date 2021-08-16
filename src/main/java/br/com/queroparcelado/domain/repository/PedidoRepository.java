package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.produto.Pedido;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PedidoRepository extends CustomJpaRepository<Pedido, Long>,
        JpaSpecificationExecutor<Pedido>,
        PedidoRepositoryQueries {
    
    List<Pedido> findByClienteId(Long idCliente);

    @Query("SELECT p FROM Pedido p ORDER BY p.id DESC")
    List<Pedido> buscarPedidosOrderDesc();
}
