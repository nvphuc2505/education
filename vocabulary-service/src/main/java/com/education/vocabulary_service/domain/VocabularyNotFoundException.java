package com.education.vocabulary_service.domain;

public class VocabularyNotFoundException
        extends RuntimeException {

  public VocabularyNotFoundException(String content) {
      super("The vocabulary with " + content + " was not found.");
  }

}
