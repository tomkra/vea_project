package com.vsb.vea.project.dto;

public class Bus extends Vehicle {
    private int capacity;

    public Bus(Person driver, String numberplate, int capacity) {
        super(driver, numberplate);
        this.capacity = capacity;
    }
}
