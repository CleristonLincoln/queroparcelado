package br.com.queroparcelado.domain.model.produto;

import br.com.queroparcelado.domain.model.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
public class Promocao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    private BigDecimal valor;

    @NotNull
    private BigDecimal qtdParcela;

    private BigDecimal taxaCartao;

    @NotNull
    private BigDecimal taxaAdministrativa;

    @CreationTimestamp
    private LocalDateTime dataCadastro;

    private LocalDateTime dataUso;

    private boolean ativo = true;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;
}
