package com.asdf.JavaProject.dto.project;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
public class ModifyProject {
    private String title;

    private String subject;

    private String explanation;

    @NotNull
    private Date started_at;

    @NotNull
    private Date ended_at;

    private String logo_image;
}
