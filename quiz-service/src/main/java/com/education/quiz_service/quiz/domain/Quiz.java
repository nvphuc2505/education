package com.education.quiz_service.quiz.domain;

import com.education.quiz_service.quiz.domain.common.QuizDifficulty;
import com.education.quiz_service.quiz.domain.common.QuizStatus;
import com.education.quiz_service.quiz.domain.common.QuizType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "quizzes")
public class Quiz {

    @Id
    private Long id;

    // @Transient
    // private List<Question> questions;

    private QuizType type;

    private QuizDifficulty difficulty;

    private Duration duration;

    private QuizStatus status;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    /*
    public static Quiz of(List<Question> questions, QuizType type, QuizDifficulty difficulty, Duration duration, QuizStatus status) {
        return new Quiz(null, questions, type, difficulty, duration, status, null, null);
    }
    */

    public static Quiz of(QuizType type, QuizDifficulty difficulty, Duration duration, QuizStatus status) {
        return new Quiz(null, type, difficulty, duration, status, null, null);
    }
}
