package com.asdf.JavaProject.service;

import com.asdf.JavaProject.config.JwtToken;
import com.asdf.JavaProject.dto.chatRoom.CreateChatRoom;
import com.asdf.JavaProject.dto.project.CreateProject;
import com.asdf.JavaProject.dto.TokenContent;
import com.asdf.JavaProject.dto.project.ModifyProject;
import com.asdf.JavaProject.entity.chatRoom.ChatRoom;
import com.asdf.JavaProject.entity.project.Project;
import com.asdf.JavaProject.entity.project.ProjectRepository;
import com.asdf.JavaProject.entity.user.User;
import com.asdf.JavaProject.entity.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    private final UserRepository userRepository;

    private final JwtToken jwtToken;

    public void createProject(String token, CreateProject createProject){

        Project project = Project.builder()
                .projectName(createProject.getTitle())
                .subject(createProject.getSubject())
                .explanation(createProject.getExplanation())
                .startAt(createProject.getStarted_at())
                .endAt(createProject.getEnded_at())
                .build();

        Project savedProject = projectRepository.save(project);

        addPersonnel(token, savedProject.getId());
    }

    public void addPersonnel(String token, String projectId){
        TokenContent tokenContext = jwtToken.decodeToken(token);

        Project project = projectRepository.findById(projectId).orElseThrow();

        project.getUserIds().add(userRepository.findByEmail(tokenContext.getEmail()).orElseThrow());

        Project updateProject = Project.builder()
                .projectName(project.getProjectName())
                .userIds(project.getUserIds())
                .chatRooms(project.getChatRooms())
                .subject(project.getSubject())
                .explanation(project.getExplanation())
                .startAt(project.getStartAt())
                .endAt(project.getEndAt())
                .build();

        projectRepository.save(updateProject);

    }

    public void addChatRoom(String token, String projectId, CreateChatRoom createChatRoom) {
        TokenContent tokenContext = jwtToken.decodeToken(token);

        Project project = projectRepository.findById(projectId).orElseThrow();

        ChatRoom chatRoom = ChatRoom.builder()
                .name(createChatRoom.getName())
                .build();

        chatRoom.getUsers().add(userRepository.findByEmail(tokenContext.getEmail()).orElseThrow());
        project.getChatRooms().add(chatRoom);

        Project updateProject = Project.builder()
                .projectName(project.getProjectName())
                .userIds(project.getUserIds())
                .chatRooms(project.getChatRooms())
                .subject(project.getSubject())
                .explanation(project.getExplanation())
                .startAt(project.getStartAt())
                .endAt(project.getEndAt())
                .build();

        projectRepository.save(updateProject);

    }
//
//    public void modifyProject(String token, String id, ModifyProject modifyProject) throws Exception{
//        TokenContent tokenContext = jwtToken.decodeToken(token);
//        //프로젝트인원에서 권한확인
//        if(!projectPersonnelRepository.findByUserId(Long.valueOf(tokenContext.getId())).get().getPermission()){
//            new Exception("권한이 없습니다.");
//        }
//
//        Project project = projectRepository.findById(Long.valueOf(id)).get();
//
//        Project updateProject = new Project(project.getId(), modifyProject.getTitle(), modifyProject.getSubject(), modifyProject.getExplanation(), modifyProject.getStarted_at(), modifyProject.getEnded_at(), modifyProject.getLogo_image(), project.getPersonals(), project.getSchedules());
//
//        projectRepository.save(updateProject);
//    }
//
//    public void deleteProject(String token, String id) throws Exception{
//        TokenContent tokenContext = jwtToken.decodeToken(token);
//        //프로젝트인원에서 권한확인
//        if(!projectPersonnelRepository.findByUserId(Long.valueOf(tokenContext.getId())).get().getPermission()){
//            new Exception("권한이 없습니다.");
//        }
//
//        projectRepository.delete(projectRepository.findById(Long.valueOf(id)).orElseThrow());
//    }
//
//    public String addSchedule(String token, String projectId, CreateSchedule createSchedule){
//        try{
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            ProjectSchedule projectSchedule = projectScheduleRepository.save(
//                    new ProjectSchedule(
//                            null,
//                            createSchedule.getContent(),
//                            createSchedule.getStatus(),
//                            projectRepository.findById(Long.valueOf(projectId)).orElseThrow(),
//                            createSchedule.getStarted_at(),
//                            createSchedule.getEnded_at(),
//                            null
//                    )
//            );
//
//            joinSchedule(token, String.valueOf(projectSchedule.getId()));
//
//            return "success";
//        }catch(Exception e){
//            new Exception(e.getMessage());
//            return "error";
//        }
//    }
//
//    public String modifySchedule(String token, String scheduleId, ModifySchedule modifySchedule){
//        try {
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            ProjectSchedule projectSchedule = projectScheduleRepository.findById(Long.valueOf(scheduleId)).orElseThrow();
//
//            projectScheduleRepository.save(
//                    new ProjectSchedule(
//                            projectSchedule.getId(),
//                            modifySchedule.getContent(),
//                            modifySchedule.getStatus(),
//                            projectSchedule.getProject(),
//                            modifySchedule.getStarted_at(),
//                            modifySchedule.getEnded_at(),
//                            projectSchedule.getPersonnels()
//                    )
//            );
//
//            return "modified";
//
//        }catch(Exception e){
//            new Exception(e.getMessage());
//            return "error";
//        }
//    }
//
//    public String deleteSchedule(String token, String scheduleId){
//        try{
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            projectScheduleRepository.delete(
//                    projectScheduleRepository.findById(Long.valueOf(scheduleId)).orElseThrow()
//            );
//            return "deleted";
//        }catch (Exception e){
//            new Exception(e.getMessage());
//            return "error";
//        }
//    }
//
//    public String completeSchedule(String token, String scheduleId){
//        try{
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            ProjectSchedule projectSchedule = projectScheduleRepository.findById(Long.valueOf(scheduleId)).orElseThrow();
//
//            projectScheduleRepository.save(
//                    new ProjectSchedule(
//                            projectSchedule.getId(),
//                            projectSchedule.getContent(),
//                            "completed",
//                            projectSchedule.getProject(),
//                            projectSchedule.getStarted_at(),
//                            projectSchedule.getEnded_at(),
//                            projectSchedule.getPersonnels()
//                    )
//            );
//
//            return "modified";
//        }catch (Exception e){
//            new Exception(e.getMessage());
//            return "error";
//        }
//    }
//
//    public void joinSchedule(String token, String scheduleId){
//        try{
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            schedulePersonnelRepository.save(
//                    new SchedulePersonnel(
//                            null,
//                            projectScheduleRepository.findById(Long.valueOf(scheduleId)).orElseThrow(),
//                            userRepository.findById(tokenContext.getId()).orElseThrow()
//                    )
//            );
//        }catch (Exception e){
//            new Exception(e.getMessage());
//        }
//    }
//
//    public void leaveSchedule(String token, String scheduleId){
//        try{
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            schedulePersonnelRepository.delete(schedulePersonnelRepository.findById(Long.valueOf(scheduleId)).orElseThrow());
//        }catch (Exception e){
//            new Exception(e.getMessage());
//        }
//    }
//
//    public void changingRoles(String token, String role) throws Exception{
//        try{
//            TokenContent tokenContext = jwtToken.decodeToken(token);
//
//            ProjectPersonnel projectPersonnel = projectPersonnelRepository.findByUserId(tokenContext.getId()).orElseThrow();
//
//            ProjectPersonnel modifyProjectPersonnel = new ProjectPersonnel(projectPersonnel.getId(), projectPersonnel.getProject(), projectPersonnel.getUser(), projectPersonnel.getPermission(), role);
//
//            projectPersonnelRepository.save(modifyProjectPersonnel);
//        }catch (Exception e){
//            new Exception(e.getMessage());
//        }
//    }
}
