package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dao.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaDaoFactory implements DaoFactory {
    @Autowired
    private PersonDaoJpa personDaoJpa;

    @Autowired
    private VehicleDaoJpa vehicleDaoJpa;

    @Override
    public PersonDao getPersonDao() {
        return personDaoJpa;
    }

    @Override
    public VehicleDao getVehicleDao() {
        return vehicleDaoJpa;
    }
}
