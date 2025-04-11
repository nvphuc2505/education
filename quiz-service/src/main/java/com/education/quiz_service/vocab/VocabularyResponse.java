package com.education.quiz_service.vocab;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VocabularyResponse {

    private String topic;

    private String word;

    private String definition;

}
