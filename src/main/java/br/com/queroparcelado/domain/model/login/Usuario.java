package br.com.queroparcelado.domain.model.login;

import br.com.queroparcelado.domain.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String login;

    private String senha;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dataCadastro;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_permissao")
    private Permissao permissao;
}
