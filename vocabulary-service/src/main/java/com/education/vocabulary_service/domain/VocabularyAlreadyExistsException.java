package com.education.vocabulary_service.domain;

public class VocabularyAlreadyExistsException extends RuntimeException {

    public VocabularyAlreadyExistsException(String word) {
        super(word + " already exists.");
    }

}
