package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Route;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class RouteDaoJpa implements RouteDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Route> getAll() {
        return em.createQuery("SELECT r FROM Route r", Route.class).getResultList();
    }

    @Override
    public void save(Route route) {
        if(route.getId() != 0) {
            em.merge(route);
        } else {
            em.persist(route);
        }
    }

    @Override
    public void delete(Route route) {
        if(!em.contains(route)) {
            route = em.merge(route);
        }
        em.remove(route);
    }

    @Override
    public Route find(long id) {
        return em.find(Route.class, id);
    }

    @Override
    public Route getVehicle(long vehicle) {
        return null;
    }

    @Override
    public Route getDriver(long driver) {
        return null;
    }
}
