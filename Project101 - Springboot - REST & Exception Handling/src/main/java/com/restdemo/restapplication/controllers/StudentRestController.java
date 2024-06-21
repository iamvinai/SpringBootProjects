package com.restdemo.restapplication.controllers;
import com.restdemo.restapplication.entity.Student;
import com.restdemo.restapplication.exceptions.StudentNotFoundException;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<Student>();
        theStudents.add(new Student("Virat","Kohli"));
        theStudents.add(new Student("Mahendra Singh","Dhoni"));
        theStudents.add(new Student("Rohit","Sharma"));
    }

    @GetMapping("/students")
    public List<Student> getStudents(){
        
        return theStudents;
    }
    //define endpoint for students/{studentId} - return single srudent by ID
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        //index into list and return student for now
        if(studentId>theStudents.size()||studentId<0){
            throw new StudentNotFoundException("Student Id not found - "+studentId);
        }
        return theStudents.get(studentId);
    }
    /*@ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exec){
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setResponse(exec.getMessage());
        error.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
     //handle othe kinds of exceptions
     @ExceptionHandler
     public ResponseEntity<StudentErrorResponse> handleGeneralException(Exception  exec){
         StudentErrorResponse error = new StudentErrorResponse();
         error.setStatus(HttpStatus.BAD_REQUEST.value());
         error.setResponse(exec.getMessage());
         error.setTimestamp(System.currentTimeMillis());
         return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
     }*/
    
   
    @PreDestroy
    public void doNothing(){
        System.out.println("In destroy");
    }
    
}
