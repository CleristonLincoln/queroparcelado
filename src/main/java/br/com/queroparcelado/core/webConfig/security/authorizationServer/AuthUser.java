package br.com.queroparcelado.core.webConfig.security.authorizationServer;

import br.com.queroparcelado.domain.model.login.Usuario;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

@Getter
public class AuthUser extends User {

    private String login;
    private Long id;


    public AuthUser(Usuario usuario, Collection<? extends GrantedAuthority> authotities) {
        super(usuario.getLogin(), usuario.getSenha(), authotities);
        this.login = usuario.getLogin();
        this.id = usuario.getId();
    }
}
