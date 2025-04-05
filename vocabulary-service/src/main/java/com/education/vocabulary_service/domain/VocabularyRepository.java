package com.education.vocabulary_service.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VocabularyRepository
        extends CrudRepository<Vocabulary, Long> {

    // Optional<Vocabulary> findByTopic(String topic);
    Optional<Vocabulary> findByWord(String word);
    boolean existsByWord(String word);

}
