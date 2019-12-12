package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.UserDao;
import com.vsb.vea.project.dto.User;
import org.hibernate.annotations.NaturalId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;
import java.util.SimpleTimeZone;

@Repository
public class UserDaoJdbcTemplate implements UserDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert userInsert;

    @Autowired
    public void initDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        userInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Users")
                .usingGeneratedKeyColumns("id")
                .usingColumns("first_name", "last_name", "personal_number");
    }

    @PostConstruct
    public void postConstructor() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS Users(id serial PRIMARY KEY, first_name VARCHAR(255), last_name VARCHAR(255), personal_number VARCHAR(255));s";
            jdbcTemplate.update(query);

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        save(new User("Tomas", "Kral", "KRA0410"));
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM Users", new UserMapper());
    }

    @Override
    public void save(User user) {
        if(user.getId() == 0) {
            BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(user);
            userInsert.executeAndReturnKey(source);
        }
    }

    @Override
    public void delete(User user) {
        String query = "DELETE FROM Users WHERE id = ?";
        jdbcTemplate.update(query, new Object[] {user.getId()});
    }

    @Override
    public User find(long id) {
        if (id == 0) return null;
        String query = "SELECT * FROM Users where id = ?";
        List<User> result = jdbcTemplate.query(query, new UserMapper(), new Object[] {id});
        return !result.isEmpty() ? result.get(0) : null;
    }
}
