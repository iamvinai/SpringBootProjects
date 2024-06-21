package com.mongospring.aosproject.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mongospring.aosproject.model.Student;
import com.mongospring.aosproject.repository.studentRepos;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
public class studentController {
    @Autowired
    studentRepos repo;
    public String getMethodName(@RequestParam String param) {
        return new String();
    }
    
    @GetMapping("/students")
    public String students(Model model){
        List<Student> s = repo.findAll();
        List<String>names =new ArrayList<String>();
        List<String>courses = new ArrayList<String>();
        for(Student st:s){
            System.out.println(st.getName());
            names.add(st.getName());
            courses.add(st.getCourse());
        }

        model.addAttribute("dataList",s);
        return "listTemplate";
    }

    
    
    @PostMapping("/post")
    public Student addStudents(@RequestBody Student student) {
        return repo.save(student);
        //return student;
    }
    
    
    
}
