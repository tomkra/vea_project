package com.vsb.vea.project.dto;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@javax.persistence.Entity
public class Person implements Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    private String personalNumber;
    private String firstName;
    private String lastName;

    @OneToOne(mappedBy = "driver")
    private Vehicle driverOf;

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Person() {
        super();
    }

    public Person(String firstName, String lastName, String personalNumber) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.personalNumber = personalNumber;
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
        Person u = (Person) e;
        firstName = u.firstName;
        lastName = u.lastName;
        personalNumber = u.personalNumber;
    }
}
