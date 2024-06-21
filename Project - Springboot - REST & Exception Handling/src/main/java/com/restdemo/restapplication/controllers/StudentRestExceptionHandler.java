package com.restdemo.restapplication.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.restdemo.restapplication.exceptions.StudentNotFoundException;

@ControllerAdvice
public class StudentRestExceptionHandler {

     @ExceptionHandler
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
     }
}
