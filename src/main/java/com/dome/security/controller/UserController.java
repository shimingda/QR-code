package com.dome.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
   @RequestMapping("/hello")
    public String getUsers() {
        return "Hello Spring Security";
    }
    @RequestMapping("/login")
    public String login() {
        return "Hello Spring Security";
    }
}
