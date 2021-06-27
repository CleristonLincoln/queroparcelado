package br.com.queroparcelado.core.webConfig.security.authorizationServer;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;

import java.util.HashMap;

public class JwtCustomClainsTokenEnhancer implements TokenEnhancer {

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {

        // previnindo requisicoes onde nao a login do usuario final
        if (authentication.getPrincipal() instanceof AuthUser) {

            var authUser = (AuthUser) authentication.getPrincipal();
            var info = new HashMap<String, Object>();

            info.put("usuario_login", authUser.getLogin());
            info.put("usuario_id", authUser.getId());

            var oauth2AccessToken_2 = (DefaultOAuth2AccessToken) accessToken;
            oauth2AccessToken_2.setAdditionalInformation(info);
        }
        return accessToken;
    }

}
