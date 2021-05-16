package br.com.queroparcelado.core.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Configuration
@EnableWebSecurity
public class ResourceServerConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .oauth2ResourceServer().jwt()
        ;
    }

    @Bean
    public JwtDecoder jwtDecoder(){

        // obrigatorio ter mais de 32 caracteres
        var secretKey = new SecretKeySpec(
                ("azsxdcfvgbhnjmkloiuytrewqazsxdcfvgbhnjmk,").getBytes(),
                "HmacSHA256");
        return NimbusJwtDecoder.withSecretKey(secretKey).build();
    }

}