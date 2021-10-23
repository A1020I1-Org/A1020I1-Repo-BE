package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonManagedReference;
>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1

import javax.persistence.*;
import java.util.Set;

@Entity
public class Account {
    @Id
    private String userName;
    @Column(length = 255)
    private String password;

    @JsonBackReference
    @OneToOne(mappedBy = "account" ,cascade = CascadeType.ALL)
    private Customer customer;

<<<<<<< HEAD
=======
    @JsonManagedReference
>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
    @OneToOne(mappedBy = "account" ,cascade = CascadeType.ALL)
    private Employee employee;

    @JsonManagedReference
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    Set<AccountRole> accountRoles;

    public Account() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Set<AccountRole> getAccountRoles() {
        return accountRoles;
    }

    public void setAccountRoles(Set<AccountRole> accountRoles) {
        this.accountRoles = accountRoles;
    }
}
