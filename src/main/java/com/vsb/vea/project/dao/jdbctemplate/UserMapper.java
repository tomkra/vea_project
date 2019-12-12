package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dto.User;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User u = new User();
        u.setId(rs.getLong("id"));
        u.setFirstName(rs.getString("first_name"));
        u.setLastName(rs.getString("last_name"));
        u.setPersonalNumber(rs.getString("personal_number"));
        return u;
    }
}
