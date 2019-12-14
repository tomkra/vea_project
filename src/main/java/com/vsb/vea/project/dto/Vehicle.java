package com.vsb.vea.project.dto;

public abstract class Vehicle {
    private Carrier carrier;
    private Person driver;
    private String numberplate;

    public Vehicle(Carrier carrier, Person driver, String numberplate) {
        this.carrier = carrier;
        this.driver = driver;
        this.numberplate = numberplate;
    }
}
