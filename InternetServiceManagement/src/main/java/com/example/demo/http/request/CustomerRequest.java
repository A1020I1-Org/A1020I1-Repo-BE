package com.example.demo.http.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequest {
    private Integer customerId;
    private String fullName;
    private String dateOfBirth;
    private String email;
//    private String address;
    private String province;
    private String district;
    private String commune;
    private String phone;
    private Boolean status;
//    private String idCard;
    private String username;
    private String password;
    private String passwordRetype;
}
