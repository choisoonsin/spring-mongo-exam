package com.example.mongo;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootApplication
public class MongoApplication {

	@Bean
	ObjectMapper objectMapper() {
		return new ObjectMapper();
	} 

	@Bean
	public Docket apiDocumentation() {
		return new Docket(DocumentationType.OAS_30)
			.useDefaultResponseMessages(false)
			.select()
			.apis(RequestHandlerSelectors.basePackage("com.example.mongo"))
			.paths(PathSelectors.any())
			.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(MongoApplication.class, args);
	}

}
