package com.vsb.vea.project.dto;

public class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(Person driver, String numberplate, int loadCapacity) {
        super(driver, numberplate);
        this.loadCapacity = loadCapacity;
    }
}
