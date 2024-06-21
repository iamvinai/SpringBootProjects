package com.springbootpractice.project1.confure;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.springbootpractice.project1.Controller;
import com.springbootpractice.project1.injections.Coach;
import com.springbootpractice.project1.injections.SoccerCoach;
import com.springbootpractice.project1.injections.SwinCoach;

@Configuration
public class SportConfig {
    @Bean("aquatic")
    @Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Coach swinCoach(){
        return new SwinCoach();
    }

    @Bean
    public Controller controller(){
        Controller c = new Controller(swinCoach(),swinCoach());
        c.setSoccerCoach(new SoccerCoach());
        return c;
    }
}
