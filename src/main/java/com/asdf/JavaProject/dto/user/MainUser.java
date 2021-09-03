package com.asdf.JavaProject.dto.user;

//import com.asdf.JavaProject.dto.ProjectSchedule.MainSchedules;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class MainUser {
    private Long id;

    private String name;

//    private List<MainSchedules> schedules;
}
