package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.PersonDao;
import com.vsb.vea.project.dto.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class PersonDaoJdbcTemplate implements PersonDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert personInsert;

    @Autowired
    public void initDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        personInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Person")
                .usingGeneratedKeyColumns("id")
                .usingColumns("first_name", "last_name", "personal_number");
    }

    @PostConstruct
    public void postConstructor() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS Person (id serial PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255), personal_number VARCHAR(255));";
            jdbcTemplate.update(query);

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        save(new Person("Tomas", "Kral", "KRA0410"));
    }

    @Override
    public List<Person> getAll() {
        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper());
    }

    @Override
    public void save(Person person) {
        if(person.getId() == 0) {
            BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(person);
            personInsert.executeAndReturnKey(source);
        }
    }

    @Override
    public void delete(Person person) {
        String query = "DELETE FROM Person WHERE id = ?";
        jdbcTemplate.update(query, new Object[] {person.getId()});
    }

    @Override
    public Person find(long id) {
        if (id == 0) return null;
        String query = "SELECT * FROM Person where id = ?";
        List<Person> result = jdbcTemplate.query(query, new PersonMapper(), new Object[] {id});
        return !result.isEmpty() ? result.get(0) : null;
    }
}
