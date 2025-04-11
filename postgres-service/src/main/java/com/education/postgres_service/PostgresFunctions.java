package com.education.postgres_service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Configuration
public class PostgresFunctions {

    private final static Logger log = LoggerFactory.getLogger(PostgresFunctions.class);



    @Bean
    public Function<QuizAcceptedMessage, Mono<Long>> preparedQuiz() {

        return quizAcceptedMessage -> {
            log.info("The quiz with id {} is prepared", quizAcceptedMessage.getQuizId());
            return Mono.just(quizAcceptedMessage.getQuizId());
        };
    }

}
