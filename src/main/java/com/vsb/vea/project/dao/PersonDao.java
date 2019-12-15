package com.vsb.vea.project.dao;

import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Vehicle;

import java.util.List;

public interface PersonDao {
    List<Person> getAll();
    void save(Person person);
    void delete(Person person);
    Person find(long id);
}
