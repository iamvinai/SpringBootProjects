package com.demospringmvc.demospringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {
    
    @RequestMapping("/showform")
    public String showForm(){
        return "helloworld-form";
    }
    @RequestMapping("/processform")
    public String processForm(){
        return "helloworld copy";
    }

    @RequestMapping("/processformversion2")
    public String convertToUpperCase(HttpServletRequest request, Model theModel){

        String name = request.getParameter("studentName");
        name = name.toUpperCase();
        String result = "Yo "+name;
        theModel.addAttribute("message",result);
        return "helloworld copy";
    }
    @PostMapping("/processformversion3")
    public String processFormVersion3(@RequestParam("studentName") String studentName, Model theModel){

        String name;
        name = studentName.toUpperCase();
        String result = "Hey "+name;
        theModel.addAttribute("message",result);
        return "helloworld copy";
    }
}
