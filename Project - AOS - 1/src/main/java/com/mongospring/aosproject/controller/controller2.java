package com.mongospring.aosproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mongospring.aosproject.model.Student;
import com.mongospring.aosproject.repository.studentRepos;

import org.springframework.web.bind.annotation.RestController;



@RestController
public class controller2 {
    @Autowired
    studentRepos repo;
    @Value("${coach.name}")
    public  String coach;
    @Value("${team.name}")
    public  String team;
    @GetMapping("/coachname")
    public String getCoachAndTeam(){
        return "Coach: "+coach+" Team: "+team;
    }
    @GetMapping("/allstudents")
    public List<Student> allstudents(Model model){
         return repo.findAll();
        
    }
    
    

    
    
    
}
