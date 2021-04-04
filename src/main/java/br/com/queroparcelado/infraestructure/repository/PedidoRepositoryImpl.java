package br.com.queroparcelado.infraestructure.repository;

import br.com.queroparcelado.domain.model.produto.Pedido;
import br.com.queroparcelado.domain.repository.PedidoRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class PedidoRepositoryImpl implements PedidoRepositoryQueries {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Pedido> filtrarPorTaxaAdministrativa(BigDecimal taxaInicial, BigDecimal taxaFinal) {

        var jpql = new StringBuilder();
        var parametros = new HashMap<String, Object>();


        jpql.append("SELECT p FROM Pedido p WHERE 0=0 ");

        if (taxaInicial != null) {
            jpql.append("AND p.taxaAdministrativa >= :taxaInicial ");
            parametros.put("taxaInicial", taxaInicial);
        }

        if (taxaFinal != null) {
            jpql.append("AND p.taxaAdministrativa <= :taxaFinal");
            parametros.put("taxaFinal", taxaFinal);
        }


        TypedQuery<Pedido> query = manager.createQuery(jpql.toString(), Pedido.class);
        parametros.forEach(query::setParameter);
        return query.getResultList();
    }
}
