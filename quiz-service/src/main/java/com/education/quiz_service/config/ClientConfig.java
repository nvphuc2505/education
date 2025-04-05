package com.education.quiz_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class ClientConfig {

    @Bean
    WebClient webClient(ClientProperties clientProperties,
                        WebClient.Builder webClientBuilder) {

        return webClientBuilder
                .baseUrl(clientProperties.getVocabularyServiceUri().toString())
                .build();

    }

}

// The ClientConfig class to configure a WebClient bean with the base URL provided by ClientProperties
