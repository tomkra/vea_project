package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dto.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
@Repository
public class PersonDaoJpa implements PersonDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Person> getAll() {
        return em.createQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public void save(Person person) {
        if(person.getId() != 0) {
            em.merge(person);
        } else {
            em.persist(person);
        }
    }

    @Override
    public void delete(Person person) {
        if(!em.contains(person)) {
            person = em.merge(person);
        }
        em.remove(person);
    }

    @Override
    public Person find(long id) {
        return null;
    }
}
