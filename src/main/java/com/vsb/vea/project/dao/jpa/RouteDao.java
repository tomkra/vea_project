package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Route;
import com.vsb.vea.project.dto.Vehicle;

import java.util.List;

public interface RouteDao {
    List<Route> getAll();
    void save(Route route);
    void delete(Route route);
    Route find(long id);
    Vehicle getVehicle(long vehicle);
    Person getDriver(long driver);
}
