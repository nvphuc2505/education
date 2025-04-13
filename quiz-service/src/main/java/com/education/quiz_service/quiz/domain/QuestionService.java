package com.education.quiz_service.quiz.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Flux<Question> findAll() {
        return questionRepository.findAll();
    }

    public Flux<Question> findByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    public Mono<Question> save(Question question) {
        return questionRepository.save(question);
    }

    public Flux<Question> saveAll(Iterable<Question> questions) {
        return questionRepository.saveAll(questions);
    }
}
