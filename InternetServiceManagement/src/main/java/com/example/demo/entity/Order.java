package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_hour")
public class Order {
    @EmbeddedId
    private OrderKey id;

    @ManyToOne
    @MapsId("customerId")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @MapsId("computerId")
    @JoinColumn(name = "computer_id")
    private Computer computer;

    private String startTime;
    private String endTime;
    private int usageTime;

    public Order() {
    }

    public OrderKey getId() {
        return id;
    }

    public void setId(OrderKey id) {
        this.id = id;
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