package com.education.api_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.HttpStatusServerEntryPoint;

// Spring Security + Spring WebFlux
@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {

        serverHttpSecurity
                .csrf(csrf -> csrf.disable())
                .authorizeExchange(
                    exchange -> {
                        exchange
                                .pathMatchers(HttpMethod.GET, "/api/v1/vocab").permitAll()
                                .anyExchange().authenticated();
                    }
                )
                //.exceptionHandling(
                //    exceptionHandlingSpec ->
                //        exceptionHandlingSpec.authenticationEntryPoint(new HttpStatusServerEntryPoint(HttpStatus.UNAUTHORIZED))
                //)
                .oauth2Login(Customizer.withDefaults());

        return serverHttpSecurity.build();
    }

}
