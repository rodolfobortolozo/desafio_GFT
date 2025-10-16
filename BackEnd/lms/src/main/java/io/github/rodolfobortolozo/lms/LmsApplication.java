package io.github.rodolfobortolozo.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {
		"io.github.rodolfobortolozo.arquitetura.core.security.repository",
		"io.github.rodolfobortolozo.lms.repository"
})
@EntityScan(basePackages = {
		"io.github.rodolfobortolozo.arquitetura.core.security.model",
		"io.github.rodolfobortolozo.lms.model"
})
@ComponentScan(basePackages = {
		"io.github.rodolfobortolozo.lms",
		"io.github.rodolfobortolozo.arquitetura"
})
public class LmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(LmsApplication.class, args);
	}

}
