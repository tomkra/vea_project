package com.vsb.vea.project.dao;

import com.vsb.vea.project.dto.User;

import java.util.List;

public interface UserDao {
    public List<User> getAll();
    public void save(User user);
    public void delete(User user);
    public User find(long id);
}
