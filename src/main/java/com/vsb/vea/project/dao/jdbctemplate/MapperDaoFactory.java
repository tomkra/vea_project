package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MapperDaoFactory implements DaoFactory {
    @Autowired
    private PersonDaoJdbcTemplate uDao;

    @Override
    public PersonDao getPersonDao() {
        return uDao;
    }
}
