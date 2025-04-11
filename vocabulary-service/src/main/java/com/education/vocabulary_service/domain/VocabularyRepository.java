package com.education.vocabulary_service.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface VocabularyRepository
        extends CrudRepository<Vocabulary, Long> {

    Iterable<Vocabulary> findByTopic(String topic);
    boolean existsByTopic(String topic);

    Optional<Vocabulary> findByWord(String word);
    // boolean existsByWord(String word);

    Iterable<Vocabulary> findByLevel(String level);
    boolean existsByLevel(String level);

}
