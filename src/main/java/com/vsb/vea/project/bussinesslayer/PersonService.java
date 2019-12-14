package com.vsb.vea.project.bussinesslayer;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private PersonDao personDao;

    @Autowired
    public void setDaoFactory(DaoFactory factory) {
        personDao = factory.getPersonDao();
    }

    public List<Person> getAllPersons() {
        return personDao.getAll();
    }

    public void saveChanges(Person person) {
        personDao.save(person);
    }

    public Person find(long id) {
        return personDao.find(id);
    }
}
