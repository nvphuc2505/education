package com.education.quiz_service.quiz.domain;

import com.education.quiz_service.quiz.domain.common.QuizDifficulty;
import com.education.quiz_service.quiz.domain.common.QuizStatus;
import com.education.quiz_service.quiz.domain.common.QuizType;
import com.education.quiz_service.vocab.VocabularyClient;
import com.education.quiz_service.vocab.VocabularyResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
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

    // Change Flux<Vocab> into Mono<Quiz>
    public Mono<Quiz> createQuizByVocabTopic(String topic) {

        return vocabularyClient
                .getAllVocabByTopic(topic)
                .collectList()
                .map(QuizService::buildAcceptedQuiz)
                .flatMap(quizRepository::save);
    }

    private static Quiz buildAcceptedQuiz(List<VocabularyResponse> vocabularies) {

        List<Question> questions = new ArrayList<>();

        for (VocabularyResponse vocab : vocabularies) {
            Question question = new Question(
                vocab.getWord(),
                List.of(vocab.getDefinition(), "temp", "temp", "temp"),
                1
            );

            questions.add(question);
        }

        return Quiz.of(questions, QuizType.VOCABULARY, QuizDifficulty.ESSAY, Duration.ofMinutes(30), QuizStatus.DRAFT);
    }

}
