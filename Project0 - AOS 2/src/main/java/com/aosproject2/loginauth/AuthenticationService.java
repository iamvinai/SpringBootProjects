package com.aosproject2.loginauth;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationService {
    private Map<String, String> userDatabase;

    public AuthenticationService() {
        userDatabase = new HashMap<>();
        // Add sample users to the database
        userDatabase.put("user1", "password1");
        userDatabase.put("user2", "password2");
        // Add more users as needed
    }

    public boolean authenticate(String username, String password) {
        return userDatabase.containsKey(username) && userDatabase.get(username).equals(password);
    }
    
    public void changePassword(String username, String newPassword) {
        userDatabase.put(username, newPassword);
    }
}

