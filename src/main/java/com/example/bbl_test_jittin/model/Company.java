package com.example.bbl_test_jittin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Company implements Serializable {
    private String name;
    private String catchPhrase;
    private String bs;
}
