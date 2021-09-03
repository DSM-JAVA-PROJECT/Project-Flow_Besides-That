package com.asdf.JavaProject.dto.user;

import com.asdf.JavaProject.entity.project.Project;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class MyPageUser {
    private String name;
    private String phone_number;
    private List<Project> projects;
}
