package com.example.demo.service;

public interface AccountService {
    boolean checkUserName(String userName);
    void save(Account account);
}
