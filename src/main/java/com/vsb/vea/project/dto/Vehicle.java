package com.vsb.vea.project.dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@javax.persistence.Entity
//@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="vehicle_type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle implements Entity {
    private Integer capacity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String numberplate;
    private String name;

    @OneToOne
	private Person driver;

    public Vehicle() {
        super();
    }

    public String getNumberplate() {
        return numberplate;
    }

    public void setNumberplate(String numberplate) {
        this.numberplate = numberplate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Person getDriver() {
        return driver;
    }

    public void setDriver(Person driver) {
        this.driver = driver;
    }

    public Vehicle(String name, String numberplate, Person driver) {
        super();
        this.name = name;
        this.numberplate = numberplate;
        this.driver = driver;
    }

    public Vehicle(String name, String numberplate) {
        super();
        this.name = name;
        this.numberplate = numberplate;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void merge(Entity e) {
        Vehicle v = (Vehicle) e;
        numberplate = v.numberplate;
    }
}
