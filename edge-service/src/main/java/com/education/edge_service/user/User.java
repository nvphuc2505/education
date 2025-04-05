package com.education.edge_service.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
public class User {

    // Immutable data class holding user data

    private final String username;
    private final String firstName;
    private final String lastName;
    private final List<String> roles;

}
