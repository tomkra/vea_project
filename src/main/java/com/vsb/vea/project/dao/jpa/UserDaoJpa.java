package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dao.UserDao;
import com.vsb.vea.project.dto.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.List;

@Transactional
@Repository
public class UserDaoJpa implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll() {
        return em.createQuery("SELECT u FROM User u", User.class).getResultList();
    }

    @Override
    public void save(User user) {
        if(user.getId() != 0) {
            em.merge(user);
        } else {
            em.persist(user);
        }
    }

    @Override
    public void delete(User user) {
        if(!em.contains(user)) {
            user = em.merge(user);
        }
        em.remove(user);
    }

    @Override
    public User find(long id) {
        return null;
    }
}
