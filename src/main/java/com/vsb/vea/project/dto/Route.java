package com.vsb.vea.project.dto;

public class Route {
    private String from;
    private String to;
    private Vehicle vehicle;
    private Person driver;

    public Route(String from, String to, Vehicle vehicle, Person driver) {
        this.from = from;
        this.to = to;
        this.vehicle = vehicle;
        this.driver = driver;
    }
}
