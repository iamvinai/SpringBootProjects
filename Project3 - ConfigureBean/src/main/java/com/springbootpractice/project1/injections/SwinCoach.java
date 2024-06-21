package com.springbootpractice.project1.injections;


//import org.springframework.stereotype.Component;



public class SwinCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15 minutes.";
    }


}
