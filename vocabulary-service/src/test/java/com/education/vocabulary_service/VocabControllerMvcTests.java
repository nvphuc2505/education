package com.education.vocabulary_service;

import com.education.vocabulary_service.domain.VocabularyNotFoundException;
import com.education.vocabulary_service.domain.VocabularyService;
import com.education.vocabulary_service.web.VocabController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VocabController.class)
public class VocabControllerMvcTests {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private VocabularyService vocabularyService;

    @Test
    void whenGetBookNotExistingThenShouldReturn404() throws Exception {
        String word = "football";
        given(vocabularyService.findByWord(word)).willThrow(VocabularyNotFoundException.class);
        mockMvc
                .perform(get("/api/v1/vocab/search/" + word))
                .andExpect(status().isNotFound());
    }

}
