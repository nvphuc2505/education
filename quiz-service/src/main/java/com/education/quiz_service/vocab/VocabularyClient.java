package com.education.quiz_service.vocab;

import com.education.quiz_service.vocab.dto.VocabResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class VocabularyClient {

    private static final String VOCAB_ROOT_API = "/vocabulary/";
    private final WebClient webClient;

    @Autowired  // Using WebClient is configured by ClientConfig.class
    public VocabularyClient(WebClient webClient) {
        this.webClient = webClient;
    }



    public Mono<VocabResponse> getVocabByWord(String word) {

        return webClient.get()
                .uri(VOCAB_ROOT_API + word)
                .retrieve()
                .bodyToMono(VocabResponse.class);
    }
}
