package com.vsb.vea.project.bussinesslayer;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.UserDao;
import com.vsb.vea.project.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao userDao;

    @Autowired
    public void setDaoFactory(DaoFactory factory) {
        userDao = factory.getUserDao();
    }

    public List<User> getAllUsers() {
        return userDao.getAll();
    }

    public void saveChanges(User user) {
        userDao.save(user);
    }

    public User find(long id) {
        return userDao.find(id);
    }
}
