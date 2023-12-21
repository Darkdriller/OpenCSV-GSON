package com.bridgelabz;

import com.opencsv.bean.CsvBindByName;

/**
 * @author Dhruv
 * @project thirdpartylibrary
 */

//POJO class for reading csv directly

public class CSVUser {
    @CsvBindByName
    private String name;
    @CsvBindByName(column = "email", required = true)
    private String email;

    public CSVUser(String name, String email, String phoneNo, String country) {
        this.name = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.country = country;
    }

    @CsvBindByName(column = "phoneNo")
    private String phoneNo;
    @CsvBindByName
    private String country;
    public String getName() {
        return name;
    }

    public CSVUser(){}
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
