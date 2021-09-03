package com.asdf.JavaProject.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class MainPageUser {
    private Long id;
    private String name;
}
