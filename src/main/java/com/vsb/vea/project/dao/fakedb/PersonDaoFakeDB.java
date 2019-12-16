package com.vsb.vea.project.dao.fakedb;

import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dao.fakedb.impl.PersonDB;
import com.vsb.vea.project.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoFakeDB implements PersonDao {
    @Autowired
	private PersonDB personDB;

    @Override
    public List<Person> getAll() {
        return personDB.getAll();
    }

    @Override
    public void save(Person person) {
		if(person.getId() == 0) {
			personDB.insert(person);
		} else{
			personDB.merge(person);
		}
	}

    @Override
    public void delete(Person person) {
        personDB.remove(person.getId());
    }

    @Override
    public Person find(long id) {
        return personDB.find(id);
    }
}