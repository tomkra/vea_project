package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dao.jpa.RouteDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperDaoFactory implements DaoFactory {
    @Autowired
    private PersonDaoJdbcTemplate uDao;

    @Autowired
    private VehicleDaoJdbcTemplate vDao;

    @Autowired
    private RouteDaoJdbcTemplate rDao;

    @Override
    public PersonDao getPersonDao() {
        return uDao;
    }

    @Override
    public VehicleDao getVehicleDao() { return vDao; }

    @Override
    public RouteDao getRouteDao() {
        return rDao;
    }
}
