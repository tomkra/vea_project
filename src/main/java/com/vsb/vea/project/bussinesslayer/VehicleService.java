package com.vsb.vea.project.bussinesslayer;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleDao vehicleDao;

    @Autowired
    public void setDaoFactory(DaoFactory factory) {
        vehicleDao = factory.getVehicleDao();
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleDao.getAll();
    }

    public void saveChanges(Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    public Vehicle find(long id) {
        return vehicleDao.find(id);
    }

    public void deleteVehicle(Vehicle vehicle) {
        vehicleDao.delete(vehicle);
    }
}
