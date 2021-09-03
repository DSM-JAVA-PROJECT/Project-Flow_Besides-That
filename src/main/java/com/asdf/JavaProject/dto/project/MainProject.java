package com.asdf.JavaProject.dto.project;

import com.asdf.JavaProject.dto.user.ListUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class MainProject {
    private Long id;
    private String title;
    private String logo_image;
    private List<ListUser> users;
}
