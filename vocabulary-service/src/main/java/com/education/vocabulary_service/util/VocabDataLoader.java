package com.education.vocabulary_service.util;

import com.education.vocabulary_service.domain.Vocabulary;
import com.education.vocabulary_service.domain.VocabularyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("testdata")
public class VocabDataLoader {

    private final VocabularyRepository vocabularyRepository;

    @Autowired
    public VocabDataLoader(VocabularyRepository vocabularyRepository) {
        this.vocabularyRepository = vocabularyRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void loadVocabTestData() {

        vocabularyRepository.deleteAll();

        Vocabulary football = Vocabulary.of("Leisure and Recreation",
                "Football",
                "noun",
                "A1",
                "/ˈfʊtbɔːl/",
                "Bóng đá",
                "The kids were outside playing football.");

        Vocabulary gym = Vocabulary.of("Leisure and Recreation",
                "Gym",
                "noun",
                "A1",
                "/dʒɪm/",
                "Phòng tập thể dục",
                "The school has recently built a new gym.");

        Vocabulary hiking = Vocabulary.of("Leisure and Recreation",
                "Hiking",
                "noun",
                "A1",
                "/ˈhaɪkɪŋ/",
                "Leo núi",
                "He loves hiking.");

        Vocabulary reading = Vocabulary.of("Leisure and Recreation",
                "Reading",
                "noun",
                "A1",
                "/ˈriːdɪŋ/",
                "Đọc sách",
                "My hobbies include reading and painting.");

        vocabularyRepository.saveAll(List.of(football, gym, hiking, reading));
    }
}
