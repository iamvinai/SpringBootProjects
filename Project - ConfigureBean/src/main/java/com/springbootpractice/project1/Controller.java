package com.springbootpractice.project1;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springbootpractice.project1.injections.Coach;

@RestController
public class Controller {

    Coach coach,anotherCoach,soccerCoach;
    

    public Controller() {
    }
    // No Need to autowire since the controller bean is initialised in the sportconfig
    public Controller(@Qualifier("aquatic") Coach coach, @Qualifier("aquatic") Coach anotherCoach){
        this.coach=coach;
        this.anotherCoach=anotherCoach;
    }
    //This gives run time error since we can inject dependencies only through one constructor which can be autowired
    public Controller(@Qualifier("soccerCoach") Coach soccerCoach){
        this.soccerCoach=soccerCoach;
    }
    //setter injection for optional dependencies
    public void setSoccerCoach(@Qualifier("soccerCoach") Coach soccerCoach){
        this.soccerCoach=soccerCoach;
    }
    @GetMapping("/check")
    public String checkScope() {
        return "Chekcing Scope: coach==anotherCoach: "+ (coach==anotherCoach);
    }
    
    @GetMapping("/dailyworkout")
    public String dailyWorkout(){
        return soccerCoach.getDailyWorkout();
    }
}
