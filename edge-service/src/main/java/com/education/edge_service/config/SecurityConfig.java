package com.education.edge_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.oauth2.client.oidc.web.server.logout.OidcClientInitiatedServerLogoutSuccessHandler;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.authentication.logout.ServerLogoutSuccessHandler;

// Spring Security + Spring WebFlux
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity,
                                                ReactiveClientRegistrationRepository clientRegistrationRepository) {

            // All requests require authentication.
        serverHttpSecurity
                .authorizeExchange(
                    exchange -> exchange.anyExchange().authenticated()
                )

                // .formLogin(Customizer.withDefaults());

                // Enables user authentication with OAuth2/OIDC
                .oauth2Login(Customizer.withDefaults())
                .logout(
                    logout ->
                        logout.logoutSuccessHandler(oidcLogoutSuccessHandler(clientRegistrationRepository))
                );

        return serverHttpSecurity.build();

    }



    private ServerLogoutSuccessHandler oidcLogoutSuccessHandler
            (ReactiveClientRegistrationRepository clientRegistrationRepository) {

        OidcClientInitiatedServerLogoutSuccessHandler oidcLogoutSuccessHandler
                = new OidcClientInitiatedServerLogoutSuccessHandler(clientRegistrationRepository);
        oidcLogoutSuccessHandler.setPostLogoutRedirectUri("{baseUrl}");

        return oidcLogoutSuccessHandler;
    }

}
