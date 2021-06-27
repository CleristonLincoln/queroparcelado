package br.com.queroparcelado.domain.repository;

import br.com.queroparcelado.domain.model.login.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String s);
}
