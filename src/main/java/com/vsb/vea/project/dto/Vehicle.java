package com.vsb.vea.project.dto;

import java.sql.Driver;

public abstract class Vehicle {
    private Carrier carrier;
    private User driver;
    private String numberplate;

    public Vehicle(Carrier carrier, User driver, String numberplate) {
        this.carrier = carrier;
        this.driver = driver;
        this.numberplate = numberplate;
    }
}
