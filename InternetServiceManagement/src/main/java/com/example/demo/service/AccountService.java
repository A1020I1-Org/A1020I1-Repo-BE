package com.example.demo.service;

import com.example.demo.entity.Account;

public interface AccountService {
    boolean checkUserName(String userName);
    void save(Account account);
}
