package com.asdf.JavaProject.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FindByToken {
    private String id;
    private String name;
    private String email;
    private String password;
    private String phone_number;
    private String profile_image;
}
