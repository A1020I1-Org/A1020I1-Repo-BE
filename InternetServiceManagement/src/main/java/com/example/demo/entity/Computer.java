package com.example.demo.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Computer {
    @Id
    private String computerId;
    private String computerLocation;
    private String computerStartUsedDate;
    private String computerWarrantyPeriod;
    private String computerConfiguration;
    private String computerIpLocal;

    @OneToMany(mappedBy = "computer", cascade = {CascadeType.ALL,CascadeType.REMOVE})
    Set<Order> orders;

    @ManyToOne(targetEntity = Manufacturer.class)
    @JoinColumn(name = "manufacturerId", referencedColumnName = "manufacturerId")
    private Manufacturer manufacturer;

    @ManyToOne(targetEntity = Status.class)
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    private Status status;

    @ManyToOne(targetEntity = Type.class)
    @JoinColumn(name = "typeId", referencedColumnName = "typeId")
    private Type type;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "computer_game",
            joinColumns = @JoinColumn(name = "computerId"),
            inverseJoinColumns = @JoinColumn(name = "gameId")
    )
    private Set<Game> games;

    public Computer() {
    }

    public Computer(String computerId, String computerLocation, String computerStartUsedDate, String computerWarrantyPeriod, String computerConfiguration, Set<Order> orders, Manufacturer manufacturer, Status status, Type type, Set<Game> games) {
        this.computerId = computerId;
        this.computerLocation = computerLocation;
        this.computerStartUsedDate = computerStartUsedDate;
        this.computerWarrantyPeriod = computerWarrantyPeriod;
        this.computerConfiguration = computerConfiguration;
        this.orders = orders;
        this.manufacturer = manufacturer;
        this.status = status;
        this.type = type;
        this.games = games;
    }

    public Computer(String computerId, String computerLocation, String computerStartUsedDate, String computerWarrantyPeriod, String computerConfiguration, String computerIpLocal, Set<Order> orders, Manufacturer manufacturer, Status status, Type type, Set<Game> games) {
        this.computerId = computerId;
        this.computerLocation = computerLocation;
        this.computerStartUsedDate = computerStartUsedDate;
        this.computerWarrantyPeriod = computerWarrantyPeriod;
        this.computerConfiguration = computerConfiguration;
        this.computerIpLocal = computerIpLocal;
        this.orders = orders;
        this.manufacturer = manufacturer;
        this.status = status;
        this.type = type;
        this.games = games;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }

    public String getComputerLocation() {
        return computerLocation;
    }

    public void setComputerLocation(String computerLocation) {
        this.computerLocation = computerLocation;
    }

    public String getComputerStartUsedDate() {
        return computerStartUsedDate;
    }

    public void setComputerStartUsedDate(String computerStartUsedDate) {
        this.computerStartUsedDate = computerStartUsedDate;
    }

    public String getComputerWarrantyPeriod() {
        return computerWarrantyPeriod;
    }

    public void setComputerWarrantyPeriod(String computerWarrantyPeriod) {
        this.computerWarrantyPeriod = computerWarrantyPeriod;
    }

    public String getComputerConfiguration() {
        return computerConfiguration;
    }

    public void setComputerConfiguration(String computerConfiguration) {
        this.computerConfiguration = computerConfiguration;
    }

    public String getComputerIpLocal() {
        return computerIpLocal;
    }

    public void setComputerIpLocal(String computerIpLocal) {
        this.computerIpLocal = computerIpLocal;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
