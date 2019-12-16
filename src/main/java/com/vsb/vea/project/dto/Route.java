package com.vsb.vea.project.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@javax.persistence.Entity
public class Route implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String routefrom;
    private String routeto;

    @ManyToOne
    private Vehicle vehicle;

    public String getRoutefrom() {
        return routefrom;
    }

    public void setRoutefrom(String from) {
        this.routefrom = from;
    }

    public String getRouteto() {
        return routeto;
    }

    public void setRouteto(String to) {
        this.routeto = to;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    @ManyToOne
    private Person driver;

    public Route() {
        super();
    }

    public Route(String from, String to, Vehicle vehicle, Person driver) {
        super();
        this.routefrom = from;
        this.routeto = to;
        this.vehicle = vehicle;
        this.driver = driver;
    }

    @Override
    public void setId(long id) {

    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public void merge(Entity e) {

    }
}
