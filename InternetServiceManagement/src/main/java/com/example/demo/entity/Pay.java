package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Pay {
    @Id
    private Integer payId;
    private double totalPayment;
    private boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @JsonBackReference
    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderHour order;

    public Pay() {
    }

    public Integer getPayId() {
        return payId;
    }

    public void setPayId(Integer payId) {
        this.payId = payId;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<OrderService> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(Set<OrderService> orderServices) {
        this.orderServices = orderServices;
    }

    public OrderHour getOrder() {
        return order;
    }

    public void setOrder(OrderHour order) {
        this.order = order;
    }
}
