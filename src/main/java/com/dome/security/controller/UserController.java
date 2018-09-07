package com.dome.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping(value = "/login" ,method =RequestMethod.POST)
    public String login() {
        System.out.println("login");
        int a=1;
        int b=2;
       return "Hello login";
    }
}
