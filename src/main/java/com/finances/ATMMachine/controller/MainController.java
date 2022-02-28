package com.finances.ATMMachine.controller;


import com.finances.ATMMachine.entity.Client;
import com.finances.ATMMachine.service.BankService;
import com.finances.ATMMachine.service.ClientService;
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
    private ClientService clientService;

    @GetMapping("/client/{Id}")
    public ResponseEntity<?> getClient(@PathVariable long Id) {
        return new ResponseEntity<>(clientService.getClientById(Id), HttpStatus.OK);
    }
    @PostMapping("/client")
    public ResponseEntity<?> saveClient(@RequestBody Client client) {
        return new ResponseEntity<>(clientService.save(client), HttpStatus.OK);
    }
}
