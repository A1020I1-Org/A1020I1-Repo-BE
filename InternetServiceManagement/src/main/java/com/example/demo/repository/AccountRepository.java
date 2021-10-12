package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,String> {
    Account findAccountByUserName(String userName);
}
