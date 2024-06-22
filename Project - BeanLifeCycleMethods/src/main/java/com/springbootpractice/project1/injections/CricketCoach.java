package com.springbootpractice.project1.injections;



import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {

    @Override
    public String getDailyWorkout() {
        return "Practice bowling for 15 minutes.";
    }
    //bean lifecycle methods
    @PostConstruct
    public void initialisation(){
        System.out.println("Initialising the Cricket application");
    }
    @PreDestroy
    public void destroymethod(){
        System.out.println("Freeing up all the resources");
    }

}
