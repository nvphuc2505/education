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

    public Iterable<Vocabulary> findByTopic(String topic) {

        if (!vocabularyRepository.existsByTopic(topic))
            throw new VocabularyNotFoundException(topic);

        return vocabularyRepository.findByTopic(topic);
    }

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
