package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;

@RestController
public class UserController {
    
    @PostMapping("/saveUser")
    public ResponseEntity<User> saveUser(User user){
        return null;
    }


}
