package com.education.quiz_service.config;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.net.URI;

@Setter
@Getter
@ConfigurationProperties(prefix = "vocabulary")
public class ClientProperties {

    @NotNull
    URI vocabularyServiceUri;

}
