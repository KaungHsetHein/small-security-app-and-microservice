package com.example.smallsecurityappdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    public String home(){
        return "welcome";
    }
    @GetMapping("/secured")
    public String securedPage(){
        return "secured";
    }
}
