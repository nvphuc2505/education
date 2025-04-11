package com.education.postgres_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.context.FunctionCatalog;
import org.springframework.cloud.function.context.test.FunctionalSpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.function.Function;

@FunctionalSpringBootTest
public class DispatchingFunctionsIntegrationTests {

    @Autowired
    private FunctionCatalog catalog;

    @Test
    void preparedQuiz() {

        Function<QuizAcceptedMessage, Mono<Long>> prepare = catalog.lookup(
            Function.class, "preparedQuiz"
        );

        long quizId = 121;

        StepVerifier.create(
                        prepare.apply(new QuizAcceptedMessage(quizId)))
                    .expectNext(quizId)
                    .verifyComplete();

    }

}
