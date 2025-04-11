package com.education.api_gateway.user;

import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
                oidcIdToken -> new User (
                        oidcIdToken.getPreferredUsername(),
                        oidcIdToken.getGivenName(),
                        oidcIdToken.getFamilyName(),
                        oidcIdToken.getClaimAsStringList("roles")
                )
            );

    }

}
