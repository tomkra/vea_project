package com.vsb.vea.project.dto;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

public class Truck extends Vehicle {
    @NotEmpty
    private Integer capacity;

    public Truck() {
        super();
    }

    public Truck(String name, String numberplate, Person driver, int capacity) {
        super(name, numberplate, driver, VehicleType.TRUCK);
        this.capacity = capacity;
    }

    public Truck(String name, String numberplate, int capacity) {
        super(name, numberplate, VehicleType.TRUCK);
        this.capacity = capacity;
    }
}
