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


    @GetMapping("/deposit/{bankCode}/{amount}")
    public ResponseEntity<?> deposit(@PathVariable String bankCode,@PathVariable float amount) {
        return new ResponseEntity<>(bankService.deposit(bankCode,amount), HttpStatus.OK);
    }
    @GetMapping("/withdraw/{bankCode}/{amount}")
    public ResponseEntity<?> withDraw(@PathVariable String bankCode,@PathVariable float amount) {
        try {
            return new ResponseEntity<>(bankService.withDraw(bankCode,amount), HttpStatus.OK);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body(e.getMessage());
        }
    }
    @GetMapping("/balance/{bankCode}")
    public ResponseEntity<?> checkBalance(@PathVariable String bankCode) {
        return new ResponseEntity<>(bankService.checkBalance(bankCode), HttpStatus.OK);
    }
}
