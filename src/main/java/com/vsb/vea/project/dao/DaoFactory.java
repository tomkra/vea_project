package com.vsb.vea.project.dao;

import com.vsb.vea.project.dao.fakedb.PersonDaoFakeDB;
import com.vsb.vea.project.dao.jpa.RouteDao;

public interface DaoFactory {
    PersonDao getPersonDao();
    VehicleDao getVehicleDao();
    RouteDao getRouteDao();
}
