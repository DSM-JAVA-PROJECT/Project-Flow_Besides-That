package com.asdf.JavaProject.controller;

import com.asdf.JavaProject.dto.ProjectSchedule.CreateSchedule;
import com.asdf.JavaProject.dto.ProjectSchedule.ModifySchedule;
import com.asdf.JavaProject.dto.project.CreateProject;
import com.asdf.JavaProject.dto.project.ModifyProject;
import com.asdf.JavaProject.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    //프로젝트 추가
    @PostMapping("/")
    private void createProject(@RequestHeader Map<String, String> header, @RequestBody CreateProject createProject){
        projectService.createProject(header.get("authorization").substring(7), createProject);
    }

    //인원 추가
    @PostMapping("person/{project_id}")
    private void addPerson(@RequestHeader Map<String, String> header, @PathVariable("project_id") String projectId){
        projectService.addPersonnel(header.get("authorization").substring(7), projectId);
    }

    @PutMapping("modify/{project_id}")
    private ResponseEntity<String> modifyProject(@RequestHeader Map<String, String> header, @PathVariable("project_id") String projectId, @RequestBody ModifyProject modifyProject){
        try{
            projectService.modifyProject(header.get("authorization").substring(7), projectId, modifyProject);
            return new ResponseEntity<>("modified", HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("delete/{project_id}")
    private ResponseEntity<String> deleteProject(@RequestHeader Map<String, String> header, @PathVariable("project_id") String projectId){
        try{
            projectService.deleteProject(header.get("authorization").substring(7), projectId);
            return new ResponseEntity<>("deleted", HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //일정 추가
    @PostMapping("schedule/{project_id}")
    private ResponseEntity<String> addSchedule(@RequestHeader Map<String, String> header, @PathVariable("project_id") String projectId, @RequestBody CreateSchedule createSchedule){
        try{
            return new ResponseEntity<>(projectService.addSchedule(header.get("authorization").substring(7), projectId, createSchedule), HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    //일정 수정
    @PutMapping("schedule/{schedule_id}")
    private ResponseEntity<String> modifySchedule(@RequestHeader Map<String, String> header, @PathVariable("schedule_id") String scheduleId, @RequestBody ModifySchedule modifySchedule){
        try{
            return new ResponseEntity<>(projectService.modifySchedule(header.get("authorization").substring(7), scheduleId, modifySchedule), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("deleteSchedule/{schedule_id}")
    private ResponseEntity<String> deleteSchedule(@RequestHeader Map<String, String> header, @PathVariable("schedule_id") String scheduleId){
        try{
            return new ResponseEntity<>(projectService.deleteSchedule(header.get("authorization").substring(7), scheduleId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("complete/{schedule_id}")
    private ResponseEntity<String> addSchedule(@RequestHeader Map<String, String> header, @PathVariable("schedule_id") String scheduleId){
        try{
            return new ResponseEntity<>(projectService.completeSchedule(header.get("authorization").substring(7), scheduleId), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("join/{schedule_id}")
    private ResponseEntity<String> joinSchedule(@RequestHeader Map<String, String> header, @PathVariable("schedule_id") String scheduleId){
        try{
            projectService.joinSchedule(header.get("authorization").substring(7), scheduleId);
            return new ResponseEntity<>("Participated", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("leave/{schedule_id}")
    private ResponseEntity<String> leaveSchedule(@RequestHeader Map<String, String> header, @PathVariable("schedule_id") String scheduleId){
        try{
            projectService.leaveSchedule(header.get("authorization").substring(7), scheduleId);
            return new ResponseEntity<>("left", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("changeRole/{role}")
    private ResponseEntity<String> changeRole(@RequestHeader Map<String, String> header, @PathVariable("role") String role){
        try{
            projectService.changingRoles(header.get("authorization").substring(7), role);
            return new ResponseEntity<>("changed", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
