package com.vsb.vea.project.dao.fakedb;

import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dao.fakedb.impl.VehicleDB;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class VehicleFakeDBFactory implements VehicleDao {
    @Autowired
	private VehicleDB vehicleDB;

    @Override
    public List<Vehicle> getAll() {
        return vehicleDB.getAll();
    }

    @Override
    public void save(Vehicle vehicle) {
        if(vehicle.getId() == 0) {
			vehicleDB.insert(vehicle);
		} else{
			vehicleDB.merge(vehicle);
		}
    }

    @Override
    public void delete(Vehicle vehicle) {
        vehicleDB.remove(vehicle.getId());
    }

    @Override
    public Vehicle find(long id) {
        return vehicleDB.find(id);
    }

    @Override
    public Vehicle getVehicle(long driver) {
        return null;
    }
}
