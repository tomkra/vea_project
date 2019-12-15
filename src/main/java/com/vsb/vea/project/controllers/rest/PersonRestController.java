package com.vsb.vea.project.controllers.rest;

import com.vsb.vea.project.bussinesslayer.PersonService;
import com.vsb.vea.project.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonRestController {
    public PersonRestController() {}

    @Autowired
    private PersonService personService;

    @RequestMapping("/rest/persons")
    public List<Person> getAll() {
        return personService.getAllPersons();
    }

    @RequestMapping("/rest/person/{id}")
    public Person getPerson(@PathVariable long id) {
        return personService.find(id);
    }
}
