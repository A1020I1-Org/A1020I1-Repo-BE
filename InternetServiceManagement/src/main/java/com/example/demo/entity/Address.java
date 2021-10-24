package com.example.demo.entity;

public class Address {
    private String province;
    private String district;
    private String ward;

    public Address(String province, String district, String ward) {
        this.province = province;
        this.district = district;
        this.ward = ward;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
