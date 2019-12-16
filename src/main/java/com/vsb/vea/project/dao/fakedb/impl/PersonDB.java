package com.vsb.vea.project.dao.fakedb.impl;

import com.vsb.vea.project.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class PersonDB extends EntityDB<Person> {

	public PersonDB() {
		insert(new Person("Pepa", "Novák", "PN1"));
		insert(new Person("Harry", "Potter", "HP111"));
	}

	@PostConstruct
	public void init() {
	}
}
