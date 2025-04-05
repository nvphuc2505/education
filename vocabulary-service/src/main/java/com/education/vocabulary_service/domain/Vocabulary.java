package com.education.vocabulary_service.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "vocabulary")
public class Vocabulary {

    @Id
    private Long id;

    @NotBlank(message = "The topic must be defined.")
    private String topic;

    @NotBlank(message = "The word must be defined.")
    private String word;

    private String wordType;

    @NotBlank(message = "The pronunciation must be defined.")
    private String pronunciation;

    @NotBlank(message = "The meaning must be defined.")
    private String meaning;

    @NotBlank(message = "The example must be defined.")
    private String example;

    @CreatedDate
    private Instant createdDate;

    @LastModifiedDate
    private Instant lastModifiedDate;

    public static Vocabulary of(String topic, String word, String wordType,
                                String pronunciation, String meaning, String example) {
        return new Vocabulary(null, topic, word, wordType,
                    pronunciation, meaning, example,
                    null, null);
    }

}
