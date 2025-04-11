package com.education.api_gateway.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class User {

    private String username;
    private String firstName;
    private String lastName;
    private List<String> roles;

}
