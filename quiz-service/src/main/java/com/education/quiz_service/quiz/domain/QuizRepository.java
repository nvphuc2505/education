package com.education.quiz_service.quiz.domain;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface QuizRepository
        extends ReactiveCrudRepository<Quiz, Long> {

}
