package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends CustomJpaRepository<Cliente, Long> {

    Optional<List<Cliente>> findByNomeContaining(String nomeCliente);
    Optional<Cliente> findByCpf(String cpfCliente);

}
