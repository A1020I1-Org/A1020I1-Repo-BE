package com.example.demo.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "pay")
public class Pay {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int payId;
    private double totalPayment;
    private boolean status;

    @OneToMany(mappedBy = "pay", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public Pay() {
    }

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
        this.totalPayment = totalPayment;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
