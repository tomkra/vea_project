package com.vsb.vea.project.dao.jpa;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JpaDaoFactory implements DaoFactory {
    @Autowired
    private UserDaoJpa userDaoJpa;

    @Override
    public UserDao getUserDao() {
        return userDaoJpa;
    }
}
