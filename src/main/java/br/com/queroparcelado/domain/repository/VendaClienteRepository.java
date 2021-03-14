package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.VendaCliente;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaClienteRepository extends CustomJpaRepository<VendaCliente, Long>, VendaClienteRepositoryQueries,
        JpaSpecificationExecutor<VendaCliente> {

}
