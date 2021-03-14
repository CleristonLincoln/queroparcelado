package br.com.queroparcelado;

import br.com.queroparcelado.infraestructure.repository.CustomJpaRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class QueroparceladoApplication {

    public static void main(String[] args) {
        SpringApplication.run(QueroparceladoApplication.class, args);
    }

}
