package com.example.demo.entity;

public class OrderServiceDTO {

    private String id;
    private int quantity;
    private String unit;
    private int totalMoney;
    private String oderDate;
    private boolean status;
    private String customer;
    private String service;
    private Integer pay;

    public OrderServiceDTO() {
    }

    public OrderServiceDTO(String id, int quantity, String unit, int totalMoney, String oderDate, boolean status, String customer, String service, Integer pay) {
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

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public Integer getPay() {
        return pay;
    }

    public void setPay(Integer pay) {
        this.pay = pay;
    }
}
