package com.education.vocabulary_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity  // Enables Spring MVC support for Spring Security
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {

        httpSecurity
                .authorizeHttpRequests(
                    authorize -> {

                        authorize
                                /*
                                .requestMatchers(HttpMethod.GET,
                                        "/api/v1/vocab",
                                        "/api/v1/vocab/topic/**",
                                        "/api/v1/vocab/**")
                                    .hasRole("student")
                                 */

                                .requestMatchers(HttpMethod.GET,
                                        "/api/v1/vocab")
                                    .permitAll()

                                .requestMatchers(HttpMethod.GET,
                                        "/api/v1/vocab/level/**")
                                    .hasRole("teacher")

                                .anyRequest().hasRole("student");
                    }
                )

                .oauth2ResourceServer(
                        oauth2 -> oauth2.jwt(
                                jwt -> jwt.jwtAuthenticationConverter(jwtAuthenticationConverter())
                        )
                )

                .sessionManagement(
                        sessionManagement ->
                                sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .csrf(AbstractHttpConfigurer::disable);

        return httpSecurity.build();

    }



    //  Mapping the roles from the JWT to granted authorities
    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {

        var jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
        jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");
        jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("roles");

        var jwtAuthenticationConverter = new JwtAuthenticationConverter();
        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);

        return jwtAuthenticationConverter;

    }


}
