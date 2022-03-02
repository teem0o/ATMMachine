package com.finances.ATMMachine.controller;


import com.finances.ATMMachine.dto.AmountDTO;
import com.finances.ATMMachine.entity.User;
import com.finances.ATMMachine.service.BankService;
import com.finances.ATMMachine.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MainController {
    @Autowired
    private BankService bankService;
    @Autowired
    private UserService userService;

    @GetMapping("/user/{Id}")
    public ResponseEntity<?> getUser(@PathVariable long Id) {
        return new ResponseEntity<>(userService.getUserById(Id), HttpStatus.OK);
    }
    @PostMapping("/user")
    public ResponseEntity<?> saveUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }


    @PostMapping("/deposit")
    public ResponseEntity<?> deposit(@RequestBody AmountDTO amount) {
        return new ResponseEntity<>(userService.deposit(amount), HttpStatus.OK);
    }

}
