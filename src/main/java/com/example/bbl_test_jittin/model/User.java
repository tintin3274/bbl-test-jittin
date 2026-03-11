package com.example.bbl_test_jittin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {
    private long id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
