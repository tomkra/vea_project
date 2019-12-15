package com.vsb.vea.project.dto;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;

@Entity
@DiscriminatorValue("truck")
public class Truck extends Vehicle {
    @NotEmpty
    private Integer capacity;

    public Truck() {
        super();
    }

    public Truck(String name, String numberplate, Person driver, int capacity) {
        super(name, numberplate, driver);
        this.capacity = capacity;
    }
}
