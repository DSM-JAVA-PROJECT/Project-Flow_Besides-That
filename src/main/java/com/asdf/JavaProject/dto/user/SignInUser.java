package com.asdf.JavaProject.dto.user;

import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
public class SignInUser {
    @Email
    private String email;

    private String password;
}
