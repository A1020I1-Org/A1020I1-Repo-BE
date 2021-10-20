package com.example.demo.entity;

public class AccountDTO{
    private String userName;

    public AccountDTO() {
    }

    public AccountDTO(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
