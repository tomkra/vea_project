package com.vsb.vea.project.converters;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dto.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonConverter implements Converter<String, Person> {

    private PersonDao personDao;

    public PersonConverter(DaoFactory daoFactory) {
        personDao = daoFactory.getPersonDao();
    }

    @Override
    public Person convert(String source) {
        if(source == null || source.isEmpty() || "null".equals(source)) {
            return null;
        }
        return personDao.find(Long.parseLong(source));
    }
}
