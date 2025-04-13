package com.education.quiz_service.quiz.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("questions")
@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Question {

    @Id
    private Long id;

    private Long quizId;

    private String content;
    private List<String> choices;
    private int correctIndex;

    public static Question of(Long quizId, String content, List<String> choices, int correctIndex) {
        return new Question(null, quizId, content, choices, correctIndex);
    }

}
