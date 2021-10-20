package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name = "order_hour")
public class Order {

    @Id
    private Integer id;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonManagedReference

    private Customer customer;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "computer_id")

    @JsonManagedReference
    private Computer computer;


    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    @JsonBackReference
    private Pay pay;

    private String startTime;
    private String endTime;
    private int usageTime;

    public Order() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public int getUsageTime() {
        return usageTime;
    }

    public void setUsageTime(int usageTime) {
        this.usageTime = usageTime;
    }
}
