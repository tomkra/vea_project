package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperDaoFactory implements DaoFactory {
    @Autowired
    private UserDaoJdbcTemplate uDao;

    @Override
    public UserDao getUserDao() {
        return uDao;
    }
}
