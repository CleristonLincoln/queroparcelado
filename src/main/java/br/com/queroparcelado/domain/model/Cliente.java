package br.com.queroparcelado.domain.model;

import br.com.queroparcelado.domain.model.produto.Pedido;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @Length(min = 5, max = 100)
    private String nome;

    @Email
    @NotNull
    private String email;

    @CPF
    @NotNull
    private String cpf;

    @Size(min = 11, max = 11)
    @NotNull
    private String fone;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_indicador")
    private Cliente indicador;

    @Length(min = 4,message = "Senha deve ter no mínimo 4 caracteres")
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente")
    List<Pedido> pedidoList = new ArrayList<>();

}
