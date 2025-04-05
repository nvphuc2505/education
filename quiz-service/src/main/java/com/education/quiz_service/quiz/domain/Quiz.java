package com.education.quiz_service.quiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "quizzes")
public class Quiz {

    @Id
    private Long id;

    private QuestionType questionType;

    private String question;

    private List<String> answers;

    private String correctAnswer;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    public static Quiz of(QuestionType questionType, String question,
                          List<String> answers, String correctAnswer) {
        return new Quiz(null, questionType, question,
                answers, correctAnswer, null, null);
    }
}
