package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;

@Entity
@Table(name = "order_service")
public class OrderService {

    @Id
    private String id;
    private int quantity;
    private String unit;
    private int totalMoney;
    private String oderDate;
    private boolean status;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "service_id")
    private Service service;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "pay_id")
    private Pay pay;

    public OrderService() {
    }

    public OrderService(String id, int quantity, String unit, int totalMoney, String oderDate, boolean status, Customer customer, Service service, Pay pay) {
        this.id = id;
        this.quantity = quantity;
        this.unit = unit;
        this.totalMoney = totalMoney;
        this.oderDate = oderDate;
        this.status = status;
        this.customer = customer;
        this.service = service;
        this.pay = pay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getOderDate() {
        return oderDate;
    }

    public void setOderDate(String oderDate) {
        this.oderDate = oderDate;
    }

    public Pay getPay() {
        return pay;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
