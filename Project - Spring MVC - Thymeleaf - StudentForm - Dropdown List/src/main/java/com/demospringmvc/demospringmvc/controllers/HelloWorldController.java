package com.demospringmvc.demospringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demospringmvc.demospringmvc.entity.Student;



@Controller
public class HelloWorldController {
    
    @RequestMapping("/showform")
    public String showForm(Model thModel){
        thModel.addAttribute("student", new Student());
        return "helloworld-form";
    }


    @PostMapping("/processformversion3")
    public String processFormVersion3(@ModelAttribute("student") Student theStudent){

        //System.out.println(theStudent.getFirstName()+ " "+theStudent.getLastName());
        return "helloworld copy";
    }
}
