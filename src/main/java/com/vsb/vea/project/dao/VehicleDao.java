package com.vsb.vea.project.dao;

import com.vsb.vea.project.dto.Vehicle;

import java.util.List;

public interface VehicleDao {
    List<Vehicle> getAll();
    void save(Vehicle vehicle);
    void delete(Vehicle vehicle);
    Vehicle find(long id);
    Vehicle getVehicle(long driver);
}
