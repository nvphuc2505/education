package com.education.vocabulary_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class VocabularyServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VocabularyServiceApplication.class, args);
	}

}
