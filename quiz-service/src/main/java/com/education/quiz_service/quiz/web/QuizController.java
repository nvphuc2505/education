package com.education.quiz_service.quiz.web;

import com.education.quiz_service.quiz.domain.Quiz;
import com.education.quiz_service.quiz.domain.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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

    // This function is used to Render data with Thymeleaf
    @GetMapping("/page")
    public String getQuizPage(Model model) {
        Flux<Quiz> quizzes = quizService.getAllQuizzes();
        model.addAttribute("quizzes", quizzes);
        return "quizPage.html";
    }

    @PostMapping("/{word}")
    public Mono<Quiz> submitQuiz(@PathVariable String word) {
        return quizService.submitQuiz(word);
    }

}
