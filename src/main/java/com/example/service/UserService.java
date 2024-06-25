package com.example.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.model.User;
import com.example.respository.AccountRepository;
import com.example.respository.UserRepository;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    // @Autowired
    // AccountRepository accountRepository;
    
    public User saveUser(User user){
        Account account = new Account();
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<12;i++){
            int num = random.nextInt(0,9);
            sb.append(num);
        }
        if(user.getAccountType()!=null){    
            account.setAccountType(user.getAccountType());
        }
        
        account.setAccountNumber(sb.toString());
        account.setActive(false);
        account.setUser(user);
        user.setAccount(account);
        return userRepository.save(user);
    }
}
