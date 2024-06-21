package com.springbootpractice.project1.injections;


import org.springframework.stereotype.Component;



@Component
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15 minutes.";
    }


}
