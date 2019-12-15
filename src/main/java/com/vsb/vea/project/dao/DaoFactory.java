package com.vsb.vea.project.dao;

public interface DaoFactory {
    PersonDao getPersonDao();
    VehicleDao getVehicleDao();
}
