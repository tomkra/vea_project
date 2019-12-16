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
    private String from;
    private String to;

    @ManyToOne
    private Vehicle vehicle;

    @ManyToOne
    private Person driver;

    public Route() {
        super();
    }

    public Route(String from, String to, Vehicle vehicle, Person driver) {
        super();
        this.from = from;
        this.to = to;
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
