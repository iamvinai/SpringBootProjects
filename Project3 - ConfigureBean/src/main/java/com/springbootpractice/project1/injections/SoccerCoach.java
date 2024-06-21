package com.springbootpractice.project1.injections;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class SoccerCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Run for 15 minutes.";
    }

}
