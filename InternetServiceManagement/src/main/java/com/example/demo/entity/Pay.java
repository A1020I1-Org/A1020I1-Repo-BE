package com.example.demo.entity;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonBackReference;
=======
import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1

import javax.persistence.*;
import java.util.Set;


@Entity
public class Pay {
    @Id
    private int payId;
    private double totalPayment;
    private boolean status;

    @JsonBackReference
    @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @OneToOne
    @JoinColumn(name = "order_id")
    private OrderHour order;

    public Pay() {
    }

<<<<<<< HEAD
    public int getPayId() {
        return payId;
    }

    public void setPayId(int payId) {
        this.payId = payId;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
=======
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(int totalPayment) {
>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
        this.totalPayment = totalPayment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

<<<<<<< HEAD
=======
    public Set<OrderService> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(Set<OrderService> orderServices) {
        this.orderServices = orderServices;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
>>>>>>> 3dfa8296fe87edfabed322497383c885f3b334c1
}
