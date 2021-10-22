package com.example.demo.service;

import com.example.demo.entity.Account;


import java.util.List;

public interface AccountService {

    Account findByUserName(String userName);
    boolean checkUserName(String userName);

    void save(Account account);

    List<Account> getAll();
}
