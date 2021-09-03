package com.asdf.JavaProject.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ReturnToken {
    private String accessToken;
    private String refreshToken;
}
