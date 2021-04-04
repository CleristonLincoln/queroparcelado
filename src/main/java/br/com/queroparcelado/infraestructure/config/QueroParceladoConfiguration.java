package br.com.queroparcelado.infraestructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("queroparcelado")
public class QueroParceladoConfiguration {



    @Getter@Setter
    private String originAllow = "http://localhost:4200";

}
