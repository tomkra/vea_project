package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dto.*;
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
public class VehicleDaoJdbcTemplate implements VehicleDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void initDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Vehicle")
                .usingGeneratedKeyColumns("id")
                .usingColumns("name", "numberplate", "capacity", "vehicletype");
    }

    @PostConstruct
    public void postConstructor() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS Vehicle (id serial PRIMARY KEY, name VARCHAR(255), numberplate VARCHAR(255), capacity INTEGER);";
            jdbcTemplate.update(query);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        save(new Truck("Tatra", "33456", new Person("Test", "Test", "ttt"), 10));
        save(new Car("Audi", "OV11"));
    }

    public List<Vehicle> getAll() {
        return jdbcTemplate.query("SELECT * FROM Vehicle ORDER BY 1", new VehicleMapper());
    }

    @Override
    public void save(Vehicle vehicle) {
        if (vehicle.getId() == 0) {
            BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(vehicle);
            simpleJdbcInsert.executeAndReturnKey(source);
        } else {
            String query = "UPDATE Vehicle " +
                    "SET name = ?, numberplate = ?, driver_id = ?, capacity = ? vehicletype = ? " +
                    "WHERE id = ?";
            jdbcTemplate.update(query,
                    vehicle.getName(),
                    vehicle.getNumberplate(),
                    vehicle.getDriver() != null ? vehicle.getDriver().getId() : null,
                    vehicle.getCapacity(),
                    vehicle.getVehicletype(),
                    vehicle.getId());
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        String query = "DELETE FROM Vehicle WHERE id = ?";
        jdbcTemplate.update(query,
                new Object[] {vehicle.getId()});
    }

    @Override
    public Vehicle find(long id) {
       if (id == 0)
            return null;
        String query = "SELECT * FROM Vehicle WHERE id = ?";
        List<Vehicle> result = jdbcTemplate.query(query, new VehicleMapper(),
                new Object[] {id});
        return !result.isEmpty() ? result.get(0) : null;
    }

    @Override
    public Vehicle getVehicle(long driver) {
        if (driver == 0)
            return null;
        String query = "SELECT * FROM Vehicle WHERE driver_id = ?";
        List<Vehicle> result = jdbcTemplate.query(query, new VehicleMapper(),
                new Object[] {driver});
        return !result.isEmpty() ? result.get(0) : null;
    }
}
