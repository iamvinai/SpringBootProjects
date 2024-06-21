package com.luv2code.springboot.cruddemo.security;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
/*import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;*/
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {

  /* */  @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        //getting users names and passwords from database instead of hardcoding
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.setUsersByUsernameQuery("select user_id,pw, active FROM members WHERE user_id=?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select user_id, role FROM roles  WHERE user_id=?");


        return jdbcUserDetailsManager;
    }

    /* @Bean
    public UserDetailsManager userDetailsManager(){
       UserDetails john = User.builder()
        .username("john")
        .password("{noop}john123")
        .roles("Employee")
        .build();
        UserDetails mary = User.builder()
        .username("mary")
        .password("{noop}mary123")
        .roles("Employee","Manager")
        .build();
        UserDetails susan = User.builder()
        .username("susan")
        .password("{noop}susan123")
        .roles("Employee","Manager","Admin")
        .build();
        
        return new InMemoryUserDetailsManager(john,mary,susan);
        
    } */
   

    @Bean 
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        
        http.authorizeHttpRequests(configurer1 -> configurer1.requestMatchers(HttpMethod.GET,"/api/employees").hasRole("EMPLOYEE")
        .requestMatchers(HttpMethod.GET,"/api/employees/**").hasRole("EMPLOYEE")
        .requestMatchers(HttpMethod.POST,"/api/employees/**").hasRole("MANAGER")
        .requestMatchers(HttpMethod.PUT,"/api/employees").hasRole("MANAGER")
        .requestMatchers(HttpMethod.DELETE,"/api/employees/**").hasRole("ADMIN"));
        //use http basic authentication
        http.httpBasic(Customizer.withDefaults());

        //disable crosssite request forgery
        //In-general not required for REST APIs that use post, put, get, and patch
        http.csrf(csrf->csrf.disable());
        return http.build();

    }
}
