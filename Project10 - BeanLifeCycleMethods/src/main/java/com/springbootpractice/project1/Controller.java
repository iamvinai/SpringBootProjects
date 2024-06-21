package com.springbootpractice.project1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.project1.injections.Coach;

@RestController
public class Controller {

    Coach coach,anotherCoach;

    public Controller() {
    }
    @Autowired
    public Controller(@Qualifier("cricketCoach") Coach coach, @Qualifier("cricketCoach") Coach anotherCoach){
        this.coach=coach;
        this.anotherCoach=anotherCoach;
    }
    @GetMapping("/check")
    public String checkScope() {
        return "Chekcing Scope: coach==anotherCoach: "+ (coach==anotherCoach);
    }
    
    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return coach.getDailyWorkout();
    }
}
