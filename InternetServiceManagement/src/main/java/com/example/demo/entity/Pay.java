package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payId;
    private int totalPayment;
    private boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Pay() {
    }

    public int getId() {
        return payId;
    }

    public void setId(int payId) {
        this.payId = payId;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
        this.totalPayment = totalPayment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Set<OrderService> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(Set<OrderService> orderServices) {
        this.orderServices = orderServices;
    }
}
