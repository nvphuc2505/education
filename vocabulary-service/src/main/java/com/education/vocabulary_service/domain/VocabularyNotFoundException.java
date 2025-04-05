package com.education.vocabulary_service.domain;

public class VocabularyNotFoundException
        extends RuntimeException {

  public VocabularyNotFoundException(String topic) {
      super("The vocabulary with topic " + topic + " was not found.");
  }
}
