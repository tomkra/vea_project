package com.vsb.vea.project.controllers.rest;

import com.vsb.vea.project.bussinesslayer.PersonService;
import com.vsb.vea.project.bussinesslayer.VehicleService;
import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleRestController {
    public VehicleRestController() {}

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/rest/vehicles")
    public List<Vehicle> getAll() {
        return vehicleService.getAllVehicles();
    }

    @RequestMapping("/rest/vehicle/{id}")
    public Vehicle getPerson(@PathVariable long id) {
        return vehicleService.find(id);
    }
}
