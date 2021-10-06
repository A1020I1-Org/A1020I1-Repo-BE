package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    private String fullName;
    private String dateOfBirth;
    private String email;
    private String address;
    private String phone;
    private Boolean status;
//    private String idCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private Account account;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Pay> pays;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL,CascadeType.REMOVE})
    Set<Order> orders;

}
