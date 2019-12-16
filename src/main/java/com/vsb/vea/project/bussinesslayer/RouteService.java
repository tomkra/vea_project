package com.vsb.vea.project.bussinesslayer;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.jpa.RouteDao;
import com.vsb.vea.project.dto.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteService {
    private RouteDao routeDao;

    @Autowired
    public void setDaoFactory(DaoFactory factory) {
        routeDao = factory.getRouteDao();
    }

    public List<Route> getAllRoutes() {
        return routeDao.getAll();
    }

    public void saveChanges(Route route) {
        routeDao.save(route);
    }

    public Route find(long id) {
        return routeDao.find(id);
    }

    public void deleteRoute(Route route) {
        routeDao.delete(route);
    }
}
