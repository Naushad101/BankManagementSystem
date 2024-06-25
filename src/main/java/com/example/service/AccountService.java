package com.example.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Account;
import com.example.model.User;
import com.example.respository.AccountRepository;
import com.example.respository.UserRepository;

@Service
public class AccountService {
    
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    UserRepository userRepository;

    public Account withdraw(String accountNumber, Integer withdrawAmount){
        User user = new User();
        Account account = new Account();
        Optional<Account> acc = accountRepository.findByAccountNumber(accountNumber);

        if(acc.isPresent()){
            account = acc.get();

            if(!account.isActive()){
                throw new RuntimeException("Your account is inactive, You are unable to withdraw or deposit");
            }
        } else {
            throw new RuntimeException("This account is not present in database");
        }

        if(withdrawAmount < 0){
            throw new IllegalArgumentException("withdraw amount can not be negative");
        }else if (withdrawAmount >= 0) {
            int oldBalance = account.getBalance();
            int updatedBalance = oldBalance - withdrawAmount;
            account.setBalance(updatedBalance);
        }
        // account.setUser(user);
        return accountRepository.save(account);
    }


}
