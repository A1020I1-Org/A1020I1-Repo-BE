package com.example.demo.dto;

import com.example.demo.entity.Account;
import com.example.demo.entity.Position;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class EmployeeDto implements Validator {
    @Id
    @NotEmpty
    @Pattern(regexp = "NV-\\d{4}")
    private String employeeId;
    @NotEmpty
    @Size(min = 5, max = 10)
    private String fullName;
    @NotEmpty
    private String dateOfBirth;
    @NotEmpty
    @Size(max = 20)
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$")
    private String email;
    @NotEmpty
    private String address;
    @NotEmpty
    @Pattern(regexp = "^\\+090\\d{9,10}$")
    private String phone;
    @NotNull
    @Min(1)
    private String level;
    @NotEmpty
    private String startWorkDate;
    @NotNull
    @Min(0)
    @Max(100)
    private int yearOfExp;
    private String avtUrl;

    private AccountDto accountDto;
    private PositionDto positionDto;

    public EmployeeDto() {
    }


    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getStartWorkDate() {
        return startWorkDate;
    }

    public void setStartWorkDate(String startWorkDate) {
        this.startWorkDate = startWorkDate;
    }

    public int getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(int yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getAvtUrl() {
        return avtUrl;
    }

    public void setAvtUrl(String avtUrl) {
        this.avtUrl = avtUrl;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public PositionDto getPositionDto() {
        return positionDto;
    }

    public void setPositionDto(PositionDto positionDto) {
        this.positionDto = positionDto;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        if(!employeeDto.fullName.matches("[A-Za-z] +")){
            errors.rejectValue("fullName", "fullName.invalidFormat");
        }

    }
}
