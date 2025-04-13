package com.education.quiz_service.quiz.domain;

import com.education.quiz_service.quiz.domain.common.QuizDifficulty;
import com.education.quiz_service.quiz.domain.common.QuizStatus;
import com.education.quiz_service.quiz.domain.common.QuizType;
import com.education.quiz_service.vocab.VocabularyClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class QuizService {

    private final VocabularyClient vocabularyClient;
    private final QuizRepository quizRepository;
    private final QuestionService questionService;

    @Autowired
    public QuizService(VocabularyClient vocabularyClient,
                       QuizRepository quizRepository,
                       QuestionService questionService) {
        this.vocabularyClient = vocabularyClient;
        this.quizRepository = quizRepository;
        this.questionService = questionService;
    }



    public Flux<Quiz> getAllQuizzes() {
        return quizRepository.findAll();
    }

    // Change Flux<Vocab> into Mono<Quiz>
    public Mono<Quiz> createQuizByVocabTopic(String topic) {

        /*
        return vocabularyClient
                .getAllVocabByTopic(topic)      // Flux<VocabularyResponse> -- Get all word by topic
                .collectList()                  // Change Flux<VocabularyResponse> into Mono<List<VocabularyResponse>>
                .map(QuizService::buildAcceptedQuiz)    // Input List<VocabularyResponse> & output Quiz
                .flatMap(quizRepository::save);         // (Mono<Quiz> save)
         */

        return vocabularyClient
                .getAllVocabByTopic(topic)
                .collectList()
                .flatMap(vocabList -> {

                    Quiz quiz = Quiz.of(
                        QuizType.VOCABULARY,
                        QuizDifficulty.EASY,
                        Duration.ofMinutes(30),
                        QuizStatus.DRAFT
                    );

                    return quizRepository.save(quiz)
                            .flatMap(savedQuiz -> {
                                List<Question> questions = vocabList.stream().map(
                                        vocab -> Question.of(
                                                quiz.getId(),
                                                ("Nghĩa của " + vocab.getDefinition() + " là: "),
                                                List.of("temp", "temp", vocab.getWord(), "temp"),
                                                3
                                        )
                                ).toList();

                                return questionService.saveAll(questions)
                                        .then().thenReturn(savedQuiz);  // return Quiz after saving all questions
                            });
                });
    }


    // Lưu Quiz trước rồi gán QuizId cho question


    /*
    private static Quiz buildAcceptedQuiz(List<VocabularyResponse> vocabularies) {

        List<Question> questions = new ArrayList<>();

        for (VocabularyResponse vocab : vocabularies) {



            Question question = Question.of(
                vocab.getWord(),
                List.of(vocab.getDefinition(), "temp", "temp", "temp"),
                1
            );

            questions.add(question);

        }

        return Quiz.of(questions, QuizType.VOCABULARY, QuizDifficulty.ESSAY, Duration.ofMinutes(30), QuizStatus.DRAFT);
    }
    */

}
