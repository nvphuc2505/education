package com.education.quiz_service.quiz.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Question {

    private String content;
    private List<String> choices;
    private int correctIndex;

}
