package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name = "name")
//    @NotBlank(message = "Name can't be blank.")
//    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name can't contain symbols.")
    private String fullName;
    @Column(name = "dateOfBirth", columnDefinition = "DATE")
    private String dateOfBirth;
    @Column(name = "email")
//    @Email(message = "Email must follow format abc@abc.com")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
//    @Pattern(regexp = "^(\\d{10}|\\d{12})$",
//            message = "Phone number must contain 9 or 12 digits.")
    private String phone;
    @Column(name = "status")
    private Boolean status;
//    private String idCard;

    @JsonManagedReference
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private Account account;

    @JsonBackReference
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @JsonBackReference
    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL,CascadeType.REMOVE})
    Set<Order> orders;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Set<OrderService> getOrderServices() {
        return orderServices;
    }

    public void setOrderServices(Set<OrderService> orderServices) {
        this.orderServices = orderServices;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    //    @Override
//    public boolean supports(Class<?> clazz) {
//        return Customer.class.isAssignableFrom(clazz);    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//        Customer customer = (Customer) target;
//        if (customer.getDateOfBirth().equals("")) {
//            errors.rejectValue("dateOfBirth", "customer.age.at.least.16");
//        } else {
//            String[] date = customer.getDateOfBirth().split("-");
//            int year = Integer.parseInt(date[0]);
//            String birthday = (year + 16) + "-" + date[1] + "-" + date[2];
//            Date birthday18th;
//            try {
//                birthday18th = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
//                if (birthday18th.compareTo(new Date()) > 0) {
//                    errors.rejectValue("dateOfBirth", "customer.age.at.least.16");
//                }
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
