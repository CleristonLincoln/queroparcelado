package br.com.queroparcelado.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "configuracao")
public class Configuracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    // taxa cobrada pela empresa que presta serviço de passar o cartao
    private BigDecimal taxaCartao;

    private BigDecimal taxaAdministrativa;

    @PositiveOrZero
    @Column(nullable = false)
    private BigDecimal qtdParcela;

    private BigDecimal valorMinimo;

    private BigDecimal valorMaximo;

}
