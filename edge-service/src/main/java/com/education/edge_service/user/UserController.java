package com.education.edge_service.user;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class UserController {

    @GetMapping("/user")
    public Mono<User> getUser() {
        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(
                    authentication ->
                            (OidcUser) authentication.getPrincipal()
                )
                .map(
                    oidcIdToken ->
                        new User(
                            oidcIdToken.getPreferredUsername(),
                            oidcIdToken.getGivenName(),
                            oidcIdToken.getFamilyName(),
                            List.of("teacher", "student")
                        )
                );
    }

    /*
     For Spring Web MVC and WebFlux controllers, besides using ReactiveSecurityContextHolder directly,
     we can use the annotations @CurrentSecurityContext and @AuthenticationPrincipal to inject
     the SecurityContext and the principal (in this case, OidcUser) respectively.
     */

}
