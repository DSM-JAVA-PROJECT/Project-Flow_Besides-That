package com.asdf.JavaProject.dto.project;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Date;

@Getter
public class CreateProject {
    private String title;

    private String subject;

    private String explanation;

    @NotNull
    private LocalDate started_at;

    @NotNull
    private LocalDate ended_at;
}
