package com.education.quiz_service.vocab;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Component
public class VocabularyClient {

    private static final String VOCAB_ROOT_API = "/api/v1/vocab";
    private final WebClient webClient;

    @Autowired
    public VocabularyClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<VocabularyResponse> getAllVocabByTopic(String topic) {
        return webClient
                .get()
                .uri(VOCAB_ROOT_API + "/topic/" + topic)
                .retrieve()
                .bodyToFlux(VocabularyResponse.class);
    }


}

/*
    -- Mono<T>—Represents a single asynchronous value or empty result (0..1)
    -- Flux<T>—Represents an asynchronous sequence of zero or more items (0..N)
 */