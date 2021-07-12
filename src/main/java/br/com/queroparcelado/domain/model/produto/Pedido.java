package br.com.queroparcelado.domain.model.produto;

import br.com.queroparcelado.domain.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.CascadeType;
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
@Builder
@Table(name = "pedido")
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigoBarra;

    @Positive
    private BigDecimal valorProposta;

    @Positive
    private BigDecimal valorFinal;

   @PositiveOrZero
    private BigDecimal qtdParcela;

    @Positive
    private BigDecimal taxaCartao;

    @Positive
    @Column(nullable = false)
    private BigDecimal taxaAdministrativa;

    @CreationTimestamp
    private LocalDateTime dataTransacao;

/*    @Enumerated(EnumType.STRING)
    private FormaRecebimento formaRecebimento;*/

    private String endereco;
    private String numero;
    private String cep;
    private String bairro;
    private String cidade;

    private String banco;
    private String agencia;
    private String conta;

    // confirma se o valor nao foi entregue ao cliente
    // 0 - nao repassado | 1 - repassado
    private boolean repassado = false;

    @JsonIgnoreProperties("pedido")
    @OneToMany(mappedBy = "pedido", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Parcela> parcelas;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

}
