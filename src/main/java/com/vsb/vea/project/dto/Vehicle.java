package com.vsb.vea.project.dto;

public abstract class Vehicle {
    private Person driver;
    private String numberplate;

    public Vehicle(Person driver, String numberplate) {
        this.driver = driver;
        this.numberplate = numberplate;
    }
}
