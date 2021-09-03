//package com.asdf.JavaProject.controller;
//
//import com.asdf.JavaProject.service.DefaultService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestHeader;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/")
//public class DefaultController {
//    private final DefaultService defaultService;
//
//    @GetMapping("/")
//    public ResponseEntity<Object> mainPage(@RequestHeader Map<String, String> header){
//        return new ResponseEntity<>(defaultService.mainPage(header.get("authorization").substring(7)), HttpStatus.OK);
//    }
//}
