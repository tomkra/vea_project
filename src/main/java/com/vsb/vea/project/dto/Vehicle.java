package com.vsb.vea.project.dto;

import org.thymeleaf.util.StringUtils;

import javax.persistence.*;
import javax.transaction.Transactional;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@javax.persistence.Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="vehicle_type", discriminatorType = DiscriminatorType.STRING)
public class Vehicle implements Entity {
    private Integer capacity;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private VehicleType vehicletype;

    @NotEmpty
    private String numberplate;
    private String name;

    @OneToOne
	private Person driver;

    @OneToMany(mappedBy = "vehicle")
	private List<Route> madeRoutes = new ArrayList<>();

    @Transient
    private String idname;

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

    public Vehicle(String name, String numberplate, Person driver, VehicleType vt) {
        super();
        this.name = name;
        this.numberplate = numberplate;
        this.driver = driver;
        setIdName();
    }

    public Vehicle(String name, String numberplate, VehicleType vt) {
        super();
        this.name = name;
        this.numberplate = numberplate;
        this.vehicletype = vt;
        setIdName();
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
        driver = v.driver;
    }

    public String getIdname() {
        setIdName();
        return idname;
    }

    public void setIdName() {
        idname = StringUtils.concat(name, " [", numberplate, "]");
    }

    public VehicleType getVehicletype() {
        return vehicletype;
    }

    public void setVehicletype(VehicleType vehicletype) {
        this.vehicletype = vehicletype;
    }
}
