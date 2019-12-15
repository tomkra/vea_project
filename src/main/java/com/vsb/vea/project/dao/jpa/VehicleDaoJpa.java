package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dto.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class VehicleDaoJpa implements VehicleDao {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vehicle> getAll() {
        return em.createQuery("SELECT v FROM Vehicle v", Vehicle.class).getResultList();
    }

    @Override
    public void save(Vehicle vehicle) {
        if(vehicle.getId() != 0) {
            em.merge(vehicle);
        } else {
            em.persist(vehicle);
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        if(!em.contains(vehicle)) {
            vehicle = em.merge(vehicle);
        }
        em.remove(vehicle);
    }

    @Override
    public Vehicle find(long id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public Vehicle getVehicle(long driver) {
        return null;
    }
}
