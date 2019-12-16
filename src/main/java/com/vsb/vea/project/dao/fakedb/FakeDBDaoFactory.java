package com.vsb.vea.project.dao.fakedb;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dao.jpa.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class FakeDBDaoFactory implements DaoFactory {

	@Autowired
	private PersonDaoFakeDB personDaoFakeDB;

	@Override
	public PersonDao getPersonDao() {
		return personDaoFakeDB;
	}

    @Override
    public VehicleDao getVehicleDao() {
        return null;
    }

    @Override
    public RouteDao getRouteDao() {
        return null;
    }
}
