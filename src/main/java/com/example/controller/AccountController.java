package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Account;
import com.example.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    
    @Autowired
    AccountService accountService;
    

    @PostMapping("/withdraw")
    public ResponseEntity<Account> withdraw(@RequestParam String accountNumber, @RequestParam Integer withdrawAmount){
        Account updatedAccount = accountService.withdraw(accountNumber, withdrawAmount);
        return new ResponseEntity<>(updatedAccount, HttpStatus.OK);
    }  
}
