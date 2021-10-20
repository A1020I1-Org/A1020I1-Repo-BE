package com.example.demo.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Computer {
    @Id
    @Pattern(regexp = "^CP[\\d]{4}$", message = "Mã máy tính phải đúng định dạng CPXXXX (X từ 0-9)")
    private String computerId;
    @Pattern(regexp = "^[A-Z]{1}[\\d]{4}$", message = "Vị trí phải đúng định dạng CPXXXX (X từ 0-9)")
    private String computerLocation;
    @DateTimeFormat
    private String computerStartUsedDate;
    @NotBlank(message = "Thời gian bảo hành không được để trống")
    private String computerWarrantyPeriod;
    @NotBlank(message = "Cấu hình máy không được để trống")
    private String computerConfiguration;


    @OneToMany(mappedBy = "computer", cascade = {CascadeType.ALL, CascadeType.REMOVE})
    Set<Order> orders;

    @NotBlank(message = "Hãng sản xuất không được để trống")
    private String computerId;
    private String computerLocation;
    private String computerStartUsedDate;
    private String computerWarrantyPeriod;
    private String computerConfiguration;

    @JsonBackReference
    @OneToMany(mappedBy = "computer", cascade = {CascadeType.ALL,CascadeType.REMOVE})
    Set<Order> orders;

    @JsonIgnore
    @ManyToOne(targetEntity = Manufacturer.class)
    @JoinColumn(name = "manufacturerId", referencedColumnName = "manufacturerId")
    private Manufacturer manufacturer;

    @JsonIgnore
    @ManyToOne(targetEntity = Status.class)
    @JoinColumn(name = "statusId", referencedColumnName = "statusId")
    @NotBlank(message = "trạng thái không được để trống")
    private Status status;

    @NotBlank(message = "Loại phải là 1, 2, 3")
    private Status status;

    @JsonIgnore
    @ManyToOne(targetEntity = Type.class)
    @JoinColumn(name = "typeId", referencedColumnName = "typeId")
    private Type type;

    @JsonIgnore
   @ManyToMany(fetch = FetchType.EAGER)
   @JoinTable(
           name = "computer_game",
           joinColumns = @JoinColumn(name = "computerId"),
           inverseJoinColumns = @JoinColumn(name = "gameId")
   )
   private Set<Game> games;

    public Computer() {
    }


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "computer_game",
            joinColumns = @JoinColumn(name = "computerId"),
            inverseJoinColumns = @JoinColumn(name = "gameId")
    )
    private Set<Game> games;

    public Computer() {
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

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
