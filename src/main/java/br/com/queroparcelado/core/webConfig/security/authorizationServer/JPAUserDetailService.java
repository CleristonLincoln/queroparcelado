package br.com.queroparcelado.core.webConfig.security.authorizationServer;

import br.com.queroparcelado.domain.model.login.Usuario;
import br.com.queroparcelado.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class JPAUserDetailService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByLogin(s)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario Nao Encontrado"));

        return new AuthUser(usuario, getGrantesAuthority(usuario));
    }

    private Collection<GrantedAuthority> getGrantesAuthority(Usuario usuario){
        return Collections.singleton(new SimpleGrantedAuthority(usuario.getPermissao().getNome()));
    }


}
