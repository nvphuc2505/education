package com.education.quiz_service.quiz.web;

import com.education.quiz_service.quiz.domain.Quiz;
import com.education.quiz_service.quiz.domain.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/quizzes")
public class QuizController {

    private final QuizService quizService;

    @Autowired
    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }



    @GetMapping
    public Flux<Quiz> getAllQuizzes() {
        return quizService.getAllQuizzes();
    }

    @PostMapping("/{topic}")
    public Mono<Quiz> submitQuiz(@PathVariable String topic) {
        return quizService.createQuizByVocabTopic(topic);
    }

}
