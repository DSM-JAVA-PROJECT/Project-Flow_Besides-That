//package com.asdf.JavaProject.service;
//
//import com.asdf.JavaProject.config.JwtToken;
//import com.asdf.JavaProject.dto.ProjectPersonnel.MainPersonnel;
//import com.asdf.JavaProject.dto.ProjectSchedule.MainSchedules;
//import com.asdf.JavaProject.dto.TokenContent;
//import com.asdf.JavaProject.dto.project.MainProject;
//import com.asdf.JavaProject.dto.user.ListUser;
//import com.asdf.JavaProject.dto.user.MainPageUser;
//import com.asdf.JavaProject.entity.user.User;
//import com.asdf.JavaProject.entity.user.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Service
//@RequiredArgsConstructor
//public class DefaultService {
//    private final JwtToken jwtToken = new JwtToken();
//    private final UserRepository userRepository;
//
//    public MainPersonnel mainPage(String token){
//        TokenContent tokenContext = jwtToken.decodeToken(token);
//
//        User user = userRepository.findById(tokenContext.getId()).orElseThrow();
//        List<ProjectPersonnel> projectPersonnels = projectPersonnelRepository.findAllByUserId(tokenContext.getId());
//
//
//
////        MainPersonnel mainPersonnel = MainPersonnel.builder()
////                .user(
////                        MainPageUser.builder().id(tokenContext.getId())
////                    .name(user.getName()).build()
////                )
////                .projects(projectPersonnels.stream().map(projectPersonnel -> MainProject.builder()
////                    .id(projectPersonnel.getProject().getId())
////                    .title(projectPersonnel.getProject().getTitle())
////                    .logo_image(projectPersonnel.getProject().getLogo_image())
////                    .users(projectPersonnelRepository.findAllByProjectId(projectPersonnel.getProject().getId()).stream().map(findUser -> ListUser.builder()
////                        .id(findUser.getUser().getId())
////                        .name(findUser.getUser().getName())
////                        .schedulePersonnels(schedulePersonnelRepository.findAllByUserId(findUser.getUser().getId())
////                                .stream().map(schedulePersonnel -> MainSchedulePersonnel.builder()
////                            .schedules(
////                                    MainSchedules.builder()
////                                            .id(schedulePersonnel.getProjectSchedule().getId())
////                                            .content(schedulePersonnel.getProjectSchedule().getContent())
////                                            .status(schedulePersonnel.getProjectSchedule().getStatus())
////                                            .started_at(schedulePersonnel.getProjectSchedule().getStarted_at())
////                                            .ended_at(schedulePersonnel.getProjectSchedule().getEnded_at())
////                                            .build()).collect(Collectors.toList())
////                            ).build())).collect(Collectors.toList())
////                    )).collect(Collectors.toList())
////                ).build();
//
//        MainPersonnel mainPersonnel = MainPersonnel.builder()
//            .user(
//                    MainPageUser.builder().id(tokenContext.getId())
//                    .name(user.getName()).build()
//            )
//            .projects(
//                projectPersonnels.stream().map(projectPersonnel -> MainProject.builder()
//                    .id(projectPersonnel.getId())
//                    .title(projectPersonnel.getProject().getTitle())
//                    .logo_image(projectPersonnel.getProject().getLogo_image())
//                    .users(projectPersonnelRepository.findAllByProjectId(projectPersonnel.getProject().getId())
//                        .stream().map(findUser -> ListUser.builder()
//                            .id(findUser.getUser().getId())
//                            .name(findUser.getUser().getName())
//                            .schedules(schedulePersonnelRepository.findAllByUserId(findUser.getUser().getId())
//                                .stream().map(schedulePersonnel -> MainSchedules.builder()//list가 와서 stream.map을 돌려야 되는듯
//                                        .id(schedulePersonnel.getProjectSchedule().getId())
//                                        .content(schedulePersonnel.getProjectSchedule().getContent())
//                                        .status(schedulePersonnel.getProjectSchedule().getStatus())
//                                        .started_at(schedulePersonnel.getProjectSchedule().getStarted_at())
//                                        .ended_at(schedulePersonnel.getProjectSchedule().getEnded_at())
//                                    .build())
//                                .collect(Collectors.toList()))
//                            .build())
//                        .collect(Collectors.toList()))
//                    .build())
//                .collect(Collectors.toList()))
//            .build();
//
//        return mainPersonnel;
//    }
//}
