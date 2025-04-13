package com.education.quiz_service.quiz.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.education.quiz_service.quiz.domain.Question;
import com.education.quiz_service.quiz.domain.QuestionService;

import reactor.core.publisher.Flux;

@RestController
@RequestMapping("api/v2/quizzes")
public class QuestionController {

    private final QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping("/questions/{quizId}")
    public Flux<Question> getAllByQuizId(@PathVariable Long quizId) {
        return questionService.findByQuizId(quizId);
    }
    
}
