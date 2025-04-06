package com.education.vocabulary_service.web;

import com.education.vocabulary_service.domain.Vocabulary;
import com.education.vocabulary_service.domain.VocabularyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vocabulary")
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

    /*
    @GetMapping("/page")
    public String vocabularyPage(Model model) {
        Iterable<Vocabulary> vocabs = vocabularyService.findAll();
        model.addAttribute("vocabs", vocabs);
        return "vocabPage";
    }
     */

    /*
    @GetMapping("/{topic}")
    public Vocabulary findByTopic(@PathVariable String topic) {
        return vocabularyService.findByTopic(topic);
    }
     */

    @GetMapping("/{word}")
    public Vocabulary findByWord(@PathVariable String word) {
        return vocabularyService.findByWord(word);

    }

    @PostMapping
    public Vocabulary submit(@Valid @RequestBody Vocabulary vocabulary) {
        return vocabularyService.save(vocabulary);
    }
}
