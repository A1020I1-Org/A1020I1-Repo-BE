package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.repository.AccountRepository;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;


    @Override
    public boolean checkUserName(String userName) {
        return accountRepository.existsById(userName);
    }

    @Override
    public void save(Account account) {
        accountRepository.save(account);
    }
}
