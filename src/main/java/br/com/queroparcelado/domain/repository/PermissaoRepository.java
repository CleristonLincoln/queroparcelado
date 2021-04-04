package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.login.Permissao;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends CustomJpaRepository<Permissao, Long> {
}
