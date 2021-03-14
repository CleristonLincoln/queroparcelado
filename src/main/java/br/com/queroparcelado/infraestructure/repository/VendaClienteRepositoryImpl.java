package br.com.queroparcelado.infraestructure.repository;

import br.com.queroparcelado.domain.model.VendaCliente;
import br.com.queroparcelado.domain.repository.VendaClienteRepositoryQueries;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

@Repository
public class VendaClienteRepositoryImpl implements VendaClienteRepositoryQueries {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<VendaCliente> filtrarPorTaxa(BigDecimal taxaInicial, BigDecimal taxaFinal) {

        var jpql = new StringBuilder();
        var parametros = new HashMap<String, Object>();

        jpql.append("SELECT v FROM VendaCliente v WHERE 0=0 ");

        if (taxaInicial != null) {
            jpql.append("AND v.percentual >= :taxaInicial ");
            parametros.put("taxaInicial", taxaInicial);
        }

        if (taxaFinal != null) {
            jpql.append("AND v.percentual <= :taxaFinal ");
            parametros.put("taxaFinal", taxaFinal);
        }
        //  var jpql = "SELECT v FROM VendaCliente v WHERE v.percentual BETWEEN :taxaInicial AND :taxaFinal";

        TypedQuery<VendaCliente> query = entityManager.createQuery(jpql.toString(), VendaCliente.class);

        parametros.forEach(query::setParameter);

        return query.getResultList();
    }
}
