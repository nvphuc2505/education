package com.education.vocabulary_service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    public Iterable<Vocabulary> findAll() {
        return vocabularyRepository.findAll();
    }

    /*
    public Vocabulary findByTopic(String topic) {
        return vocabularyRepository.findByTopic(topic)
                                .orElseThrow(
                                        () -> new VocabularyNotFoundException(topic)
                                );
    }
     */

    public Vocabulary findByWord(String word) {
        return vocabularyRepository
                    .findByWord(word)
                    .orElseThrow(
                            () -> new VocabularyNotFoundException(word)
                    );
    }

    public Vocabulary save(Vocabulary vocabulary) {
        return vocabularyRepository.save(vocabulary);
    }
}
