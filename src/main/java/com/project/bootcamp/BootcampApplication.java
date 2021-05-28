package com.project.bootcamp;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.management.openmbean.OpenMBeanParameterInfo;



@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootcampApplication.class, args);
	}

	@Bean
	public OpenAPI customOpenAPI(@Value("${application.description}") String description){
		return new OpenAPI().info(new Info()
				.title(description)
				.version("1.0")
				.termsOfService("http://swagger.io/terms")
				.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}


/*

REST (Representational State Transfer): Definição de características fundamentais para a construção de aplicações
Web seguindo boas práticas.

API (Application Programming Interface): Conjunto de rotinas e padrões estabelecidos e documentados por uma
determinada aplicação.

Métodos:

1) GET - Obter um recurso
2) POST - Criar um recurso
3) PUT - Atualizar um recurso
4) DELETE - Remover um recurso

Code Responde:

1XX - Informações gerais
2XX - Sucesso
3XX - Redirecionamento
4XX - Erros relacionados ao tratamento dos dados no servidor
5XX - Erro no servidor

JSON: Formato leve de troca de informações/dados entre sistemas

	Exemplo:

	{
		"firstName": "Othon",
		"lastName": "Silva",
	}

 */