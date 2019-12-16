//package com.vsb.vea.project.dto;
//
//import javax.persistence.*;
//import javax.persistence.Entity;
//import javax.validation.constraints.NotEmpty;
//
//@Entity
//public class Truck extends Vehicle {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id;
//
//    @NotEmpty
//    private Integer capacity;
//
//    @OneToOne
//	private Person driver;
//
//    public Truck() {
//        super();
//    }
//
//    public Truck(String name, String numberplate, Person driver, int capacity) {
//        super(name, numberplate, driver);
//        this.capacity = capacity;
//    }
//}
