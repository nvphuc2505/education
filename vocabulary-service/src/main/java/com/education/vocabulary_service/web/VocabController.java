package com.education.vocabulary_service.web;

import com.education.vocabulary_service.domain.Vocabulary;
import com.education.vocabulary_service.domain.VocabularyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/vocab")
public class VocabController {

    private final VocabularyService vocabularyService;

    @Autowired
    public VocabController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }



    @GetMapping
    public Iterable<Vocabulary> findAll() {
        return vocabularyService.findAll();
    }

    @GetMapping("/topic/{topic}")
    public Iterable<Vocabulary> findByTopic(@PathVariable String topic) {
        return vocabularyService.findByTopic(topic);
    }

    @GetMapping("/search/{word}")
    public Vocabulary findByWord(@PathVariable String word) {
        return vocabularyService.findByWord(word);

    }

    @GetMapping("/level/{level}")
    public Iterable<Vocabulary> findByLevel(@PathVariable String level) {
        return vocabularyService.findByLevel(level);
    }



    @PostMapping
    public Vocabulary submit(@Valid @RequestBody Vocabulary vocabulary) {
        return vocabularyService.save(vocabulary);
    }



    @DeleteMapping("/delete/{id}")
    public Vocabulary delete (@PathVariable Long id) {
        return vocabularyService.deleteById(id);
    }
}
