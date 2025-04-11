package com.education.vocabulary_service.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class VocabularyService {

    private final VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabularyService(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }



    // GET
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

    public Iterable<Vocabulary> findByLevel(String level) {

        if(!vocabularyRepository.existsByLevel(level))
            throw new VocabularyNotFoundException(level);

        return vocabularyRepository.findByLevel(level);
    }



    // POST
    public Vocabulary save(Vocabulary vocabulary) {

        vocabularyRepository.findAll().forEach(
            vocab -> {
                if (Objects.equals(vocabulary.getWord(), vocab.getWord()) &&
                        Objects.equals(vocabulary.getType(), vocab.getType()))
                    throw new VocabularyAlreadyExistsException(vocabulary.getWord());
            }
        );

        return vocabularyRepository.save(vocabulary);
    }



    // DELETE
    public Vocabulary deleteById(Long id) {

        Vocabulary vocabulary = vocabularyRepository.findById(id).orElse(null);

        if(vocabulary != null)
            vocabularyRepository.deleteById(id);

        return vocabulary;
    }
}
