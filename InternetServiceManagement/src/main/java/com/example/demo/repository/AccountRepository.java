package com.example.demo.repository;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<Account> findByUserName(String username);
<<<<<<< HEAD
=======

>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
}
