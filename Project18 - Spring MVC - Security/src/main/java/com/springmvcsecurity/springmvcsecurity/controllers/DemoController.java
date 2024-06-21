package com.springmvcsecurity.springmvcsecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {
    
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/leaders")
    public String showLeadersPage(){
        return "leaders";
    }
    @GetMapping("/systems")
    public String showSystemsPage(){
        return "systems";
    }
    @GetMapping("/access-denied")
    public String accessDenied(){
        return "accessDenied";
    }
}
