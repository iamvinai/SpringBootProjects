package com.aosproject2.loginauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aosproject2.loginauth.AuthenticationService;

@Controller
public class ServerController {
    @Autowired
    private AuthenticationService authService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "loginPage.html";
    }
    @GetMapping("/profile")
    public String showProfile() {
        return "profile.html";
    }

    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestParam String username, @RequestParam String password) {
        if (authService.authenticate(username, password)) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }

    @PostMapping("/reset-password")
    @ResponseBody
    public String resetPassword(@RequestParam String username, @RequestParam String oldPassword, @RequestParam String newPassword) {
        if (authService.authenticate(username, oldPassword)) {
            authService.changePassword(username, newPassword);
            return "Password reset successful";
        } else {
            return "Invalid username or old password";
        }
    }
}

