package br.com.queroparcelado.infraestructure.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("queroparcelado")
public class QueroParceladoConfiguration {

    @Value("${br.com.queroparcelado.corsOrigin}")
    private static String CORS_NAME;


    @Getter@Setter
    private String originAllow = "*";

}
