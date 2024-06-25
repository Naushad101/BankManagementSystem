package com.example.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.model.User;
import com.example.respository.AccountRespository;
import com.example.respository.UserRespository;

@Service
public class UserService {

    @Autowired
    UserRespository userRespository;

    @Autowired
    AccountRespository accountRespository;
    
    public ResponseEntity<User> saveUser(User user){
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
        account.setBalance(user.getBalance());
        account.setAccountNumber(sb.toString());
        userRespository.save(user);
        accountRespository.save(account);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
}
