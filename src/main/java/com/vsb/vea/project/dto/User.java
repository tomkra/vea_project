package com.vsb.vea.project.dto;

public class User {
    private long id;
    private String personalNumber;
    private String firstName;
    private String lastName;
    private Carrier carrier;

    public User(String personalNumber, String firstName, String lastName) {

    }

    public User(String personalNumber, String firstName, String lastName, Carrier carrier) {

    }
}
