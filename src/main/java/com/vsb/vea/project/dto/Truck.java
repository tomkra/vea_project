package com.vsb.vea.project.dto;

public class Truck extends Vehicle {
    private int loadCapacity;

    public Truck(Carrier carrier, Person driver, String numberplate, int loadCapacity) {
        super(carrier, driver, numberplate);
        this.loadCapacity = loadCapacity;
    }
}
