package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
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
public class Customer implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer customerId;
    @Column(name = "name")
    @NotBlank(message = "Name can't be blank.")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name can't contain symbols.")
    private String fullName;
    @Column(name = "dateOfBirth", columnDefinition = "DATE")
    private String dateOfBirth;
    @Column(name = "email")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$",
            message = "Email must follow format abc@abc.com")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "phone")
    @Pattern(regexp = "^(\\d{10}|\\d{12})$",
            message = "Phone number must contain 9 or 12 digits.")
    private String phone;
    @Column(name = "status")
    private Boolean status;
//    private String idCard;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userName",referencedColumnName = "userName")
    private Account account;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    Set<OrderService> orderServices;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL,CascadeType.REMOVE})
    Set<Order> orders;

    @Override
    public boolean supports(Class<?> clazz) {
        return Customer.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        Customer customer = (Customer) target;
        if (customer.getDateOfBirth().equals("")) {
            errors.rejectValue("dateOfBirth", "customer.age.at.least.16");
        } else {
            String[] date = customer.getDateOfBirth().split("-");
            int year = Integer.parseInt(date[0]);
            String birthday = date[0] + "-" + date[1] + "-" + (year + 16);
            Date birthday18th;
            try {
                birthday18th = new SimpleDateFormat("dd-MM-yyyy").parse(birthday);
                if (birthday18th.compareTo(new Date()) > 0) {
                    errors.rejectValue("dateOfBirth", "customer.age.at.least.16");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
