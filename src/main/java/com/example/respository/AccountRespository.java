package com.example.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Account;
@Repository
public interface AccountRespository extends JpaRepository<Account,Long> {
    
}
