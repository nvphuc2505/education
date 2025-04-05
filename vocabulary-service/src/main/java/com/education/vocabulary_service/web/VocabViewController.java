package com.education.vocabulary_service.web;

import com.education.vocabulary_service.domain.Vocabulary;
import com.education.vocabulary_service.domain.VocabularyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/vocabulary")
public class VocabViewController {

    private final VocabularyService vocabularyService;

    @Autowired
    public VocabViewController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    // Hiển thị trang từ vựng với Thymeleaf
    @GetMapping("/page")
    public String vocabularyPage(Model model) {
        Iterable<Vocabulary> vocabs = vocabularyService.findAll();
        model.addAttribute("vocabs", vocabs);  // Thêm từ vựng vào model để render
        return "vocabPage";  // Trả về tên của file HTML (Thymeleaf sẽ tìm file vocabPage.html trong thư mục templates)
    }

    /*
    // Tìm từ vựng theo từ khóa (word)
    @GetMapping("/{word}")
    public String findByWord(@PathVariable String word, Model model) {
        Vocabulary vocab = vocabularyService.findByWord(word);
        model.addAttribute("vocab", vocab);
        return "vocabDetail";  // Trả về trang chi tiết từ vựng
    }
     */
}
