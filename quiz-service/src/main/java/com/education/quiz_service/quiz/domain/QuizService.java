package com.education.quiz_service.quiz.domain;

import com.education.quiz_service.vocab.dto.VocabResponse;
import com.education.quiz_service.vocab.VocabularyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class QuizService {

    private final VocabularyClient vocabularyClient;
    private final QuizRepository quizRepository;

    @Autowired
    public QuizService(VocabularyClient vocabularyClient, QuizRepository quizRepository) {
        this.vocabularyClient = vocabularyClient;
        this.quizRepository = quizRepository;
    }

    public Flux<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    public Mono<Quiz> submitQuiz(String word) {

        return vocabularyClient
                .getVocabByWord(word)
                .map(QuizService::buildAcceptedQuiz)
                .flatMap(quizRepository::save);
    }

    public static Quiz buildAcceptedQuiz(VocabResponse vocab) {
        return Quiz.of(QuestionType.MULTIPLE_CHOICE, "The meaning of " + vocab.getWord() + " is:",
                List.of("A. Đọc sách", "B. Trượt tuyết", "C. " + vocab.getMeaning(), "D. Bóng rổ"), vocab.getMeaning());
    }
}
