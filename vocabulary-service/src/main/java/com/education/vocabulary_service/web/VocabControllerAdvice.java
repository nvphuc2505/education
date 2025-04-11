package com.education.vocabulary_service.web;


import com.education.vocabulary_service.domain.VocabularyAlreadyExistsException;
import com.education.vocabulary_service.domain.VocabularyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// This class used to handle with global exception handling for @RestController
@RestControllerAdvice
public class VocabControllerAdvice {

    @ExceptionHandler(VocabularyNotFoundException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String vocabularyNotFoundHandler(VocabularyNotFoundException exception) {
        return exception.getMessage();
    }

    @ExceptionHandler(VocabularyAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    String vocabularyAlreadyExistsHandler(VocabularyAlreadyExistsException exception) {
        return exception.getMessage();
    }

}
