package com.example.respository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {
    
    Optional<Account> findByAccountNumber(String accountNumber);
}