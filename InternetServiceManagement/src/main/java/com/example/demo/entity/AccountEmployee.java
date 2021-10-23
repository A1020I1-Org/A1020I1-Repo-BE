package com.example.demo.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

public class AccountEmployee {
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
//    @Pattern(regexp = "^\\+090\\d{9,10}$")
    private String phone;
    @NotNull
    private String level;
    @NotEmpty
    private String startWorkDate;
    @NotNull
    @Min(0)
    @Max(100)
    private int yearOfExp;
    private String avtUrl;
    private int idPosition;
    @NotBlank(message = "User name must not blank.")
    @Size(min = 5, max = 15)
    private String userName;
    @Size(min = 5, max = 15)
    private String password;

    public AccountEmployee() {
    }

    public AccountEmployee(String employeeId, String fullName, String dateOfBirth, String email, String address, String phone, String level, String startWorkDate, int yearOfExp, String avtUrl, int idPosition, String userName, String password) {
        this.employeeId = employeeId;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.level = level;
        this.startWorkDate = startWorkDate;
        this.yearOfExp = yearOfExp;
        this.avtUrl = avtUrl;
        this.idPosition = idPosition;
        this.userName = userName;
        this.password = password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }
}
