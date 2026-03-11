package com.example.bbl_test_jittin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Address implements Serializable {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
}
