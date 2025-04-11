package com.education.quiz_service;

import com.education.quiz_service.quiz.domain.*;
import com.education.quiz_service.quiz.domain.common.QuizDifficulty;
import com.education.quiz_service.quiz.domain.common.QuizStatus;
import com.education.quiz_service.quiz.domain.common.QuizType;
import com.education.quiz_service.quiz.web.QuizController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

import static org.mockito.Mockito.when;

@WebFluxTest(QuizController.class)
public class QuizControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockitoBean
    private QuizService quizService;

    @Test
    void submitQuiz_shouldReturnCreatedQuiz() {
        // Given
        String topic = "animals";
        Quiz mockQuiz = Quiz.of(
                List.of(new Question("Dog", List.of("A domestic animal", "temp", "temp", "temp"), 0)),
                QuizType.VOCABULARY,
                QuizDifficulty.ESSAY,
                Duration.ofMinutes(30),
                QuizStatus.DRAFT
        );

        // Mocking service
        when(quizService.createQuizByVocabTopic(topic)).thenReturn(Mono.just(mockQuiz));

        // When & Then
        webTestClient.post()
                .uri("/quizzes/{topic}", topic)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.questions[0].content").isEqualTo("Dog")  // not 'content'
                .jsonPath("$.type").isEqualTo("VOCABULARY")
                .jsonPath("$.status").isEqualTo("DRAFT");

    }
}
