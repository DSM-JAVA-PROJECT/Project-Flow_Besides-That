package com.asdf.JavaProject.dto.project;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class ProjectSave {
    private Long id;

    private String title;

    private String subject;

    private String explanation;

    private Date started_at;

    private Date ended_at;

    private String logo_image;

    private String field;

    private boolean permission;
}
