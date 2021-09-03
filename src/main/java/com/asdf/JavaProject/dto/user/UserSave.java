package com.asdf.JavaProject.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class UserSave {
    private Long id;

    private String name;

    private String email;

    private String phone_number;

    private String profile_image;
}
