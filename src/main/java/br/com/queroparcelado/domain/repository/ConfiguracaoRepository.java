package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.Configuracao;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracaoRepository extends CustomJpaRepository<Configuracao, Long> {
}
