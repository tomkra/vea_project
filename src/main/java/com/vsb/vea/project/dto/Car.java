package com.vsb.vea.project.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

public class Car extends Vehicle {
    public Car() {
        super();
    }

    public Car(String name, String numberplate, Person driver) {
        super(name, numberplate, driver, VehicleType.CAR);
    }

    public Car(String name, String numberplate) {
        super(name, numberplate, VehicleType.CAR);
    }
}
