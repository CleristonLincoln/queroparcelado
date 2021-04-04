package br.com.queroparcelado.domain.model.produto;

import br.com.queroparcelado.domain.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoBarra;

    @Positive
    private BigDecimal valor;

   @PositiveOrZero
    private BigDecimal qtdParcela;

    @Positive
    private BigDecimal taxaCartao;

    @Positive
    @Column(nullable = false)
    private BigDecimal taxaAdministrativa;

    @CreationTimestamp
    private LocalDateTime dataTransacao;

    @JsonIgnoreProperties("pedido")
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY)
    private List<Parcela> parcelas;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

}
