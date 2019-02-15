package com.dome.security.controller;

import com.dome.annotation.TestAnnotation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@TestAnnotation
@RestController
public class TestController {
    @TestAnnotation
    @RequestMapping("/test")
    public String getUsers() {
        System.out.println("test");
        return "test";
    }
}
