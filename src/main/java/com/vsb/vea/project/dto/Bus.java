package com.vsb.vea.project.dto;

public class Bus extends Vehicle {
    private int capacity;

    public Bus(Carrier carrier, User driver, String numberplate, int capacity) {
        super(carrier, driver, numberplate);
        this.capacity = capacity;
    }
}
