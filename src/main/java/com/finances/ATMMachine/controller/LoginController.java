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
    }

    @PostMapping("/verify")
    public ResponseEntity<?> verify(@RequestParam(name = "id", required = true) long id,
                                    @RequestParam(name = "twoFaCode", required = true) String twoFaCode) {
        if (userService.checkCode(id, twoFaCode)){
            return new ResponseEntity<>("good",HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    @GetMapping("/user")
    public ResponseEntity<?> getUsers() {
        long g = (System.currentTimeMillis()/1000) + 120;
        long h = System.currentTimeMillis()/1000;
        long i = System.currentTimeMillis()/1000;
        long j = System.currentTimeMillis()/1000;
        long k = System.currentTimeMillis()/1000;
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }


}
