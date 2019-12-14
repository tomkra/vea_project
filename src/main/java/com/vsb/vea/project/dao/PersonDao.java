package com.vsb.vea.project.dao;

import com.vsb.vea.project.dto.Person;

import java.util.List;

public interface PersonDao {
    public List<Person> getAll();
    public void save(Person person);
    public void delete(Person person);
    public Person find(long id);
}
