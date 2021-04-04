package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.Configuracao;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface ConfiguracaoRepository extends CustomJpaRepository<Configuracao, Long> {

    Configuracao findByQtdParcela(BigDecimal qtdParcela);

}
