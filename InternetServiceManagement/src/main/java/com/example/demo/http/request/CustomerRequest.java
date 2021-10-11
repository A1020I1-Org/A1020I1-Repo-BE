package com.example.demo.http.request;

import com.example.demo.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerRequest implements Validator {
    private Integer customerId;

    @NotBlank(message = "Name can't be blank.")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "Name can't contain symbols.")
    private String fullName;
    private String dateOfBirth;
    @Email(message = "Email must follow format abc@abc.com")
    private String email;
//    private String address;
    private String province;
    private String district;
    private String commune;
    @Pattern(regexp = "^(\\d{10}|\\d{12})$",
            message = "Phone number must contain 9 or 12 digits.")
    private String phone;
    private Boolean status;
//    private String idCard;
    @NotBlank(message = "Username can't be blank.")
    private String username;
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,20}$",
            message = "Password must have minimum 8 and maximum 20 characters, at least one uppercase letter," +
                    " one lowercase letter, one number and one special character.")
    private String password;
    private String passwordRetype;

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerRequest.class.isAssignableFrom(clazz);    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerRequest customer = (CustomerRequest) target;
        if (customer.getDateOfBirth().equals("")) {
            errors.rejectValue("dateOfBirth", "customer.age.at.least.16");
        } else {
            String[] date = customer.getDateOfBirth().split("-");
            int year = Integer.parseInt(date[0]);
            String birthday = (year + 16) + "-" + date[1] + "-" + date[2];
            Date birthday18th;
            try {
                birthday18th = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
                if (birthday18th.compareTo(new Date()) > 0) {
                    errors.rejectValue("dateOfBirth", "customer.age.at.least.16");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
