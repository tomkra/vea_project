package com.vsb.vea.project.dao.fakedb.impl;

import com.vsb.vea.project.dto.Car;
import com.vsb.vea.project.dto.Truck;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class VehicleDB extends EntityDB<Vehicle> {
    public VehicleDB() {
        insert(new Car("Skoda", "SPZ1"));
        insert(new Truck("Avia", "SPZ2", 10));
    }

    @PostConstruct
    public void init() {
    }
}
