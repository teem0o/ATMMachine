package com.finances.ATMMachine.controller;

import com.finances.ATMMachine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    UserService userService;


    @PostMapping("/auth/login")
    public void login(@RequestParam(name = "username", required = true) String username,
                      @RequestParam(name = "password", required = true) String password) {
        System.out.println(username+password);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUseres() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}
