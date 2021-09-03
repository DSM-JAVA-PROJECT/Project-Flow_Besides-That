package com.asdf.JavaProject.dto.user;

//import com.asdf.JavaProject.dto.ProjectSchedule.MainSchedules;
//import com.asdf.JavaProject.dto.SchedulePersonnel.MainSchedulePersonnel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class ListUser {
    private Long id;
    private String name;
//    private List<MainSchedules> schedules;
}
