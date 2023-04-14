package br.com.edusync.exemplo;

import br.com.edusync.exemplo.storage.StorageService;
import br.com.edusync.exemplo.storage.StorageProperties;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

// Projeto de Exemplo com SpringDoc e Cadastro de Imagem
// Documentação base Cadastro de Imagem: https://spring.io/guides/gs/uploading-files/
@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
// Anotação do SpringDoc de informações base do seu projeto
@OpenAPIDefinition(
		info = @Info(
				title = "Documentação Teste",
				description = "API de Teste",
				version = "v1.0",
				contact = @Contact(
						name = "BRQ",
						email = "teste@brq.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.javaguides.net/license"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Link de Apoio",
				url = "https://tjf.totvs.com.br/docs/open-api"
		)
)
public class ExemploApplication {


	public static void main(String[] args) {
		SpringApplication.run(ExemploApplication.class, args);
	}

 	// Cria a pasta output-dir onde as imagens serão guardadas
	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}

}
