package com.example.bbl_test_jittin.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Geo implements Serializable {
    private String lat;
    private String lng;
}
