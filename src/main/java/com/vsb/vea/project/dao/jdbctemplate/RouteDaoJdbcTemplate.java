package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dao.jpa.RouteDao;
import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Route;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.function.support.RouterFunctionMapping;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.List;

@Repository
public class RouteDaoJdbcTemplate implements RouteDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public void initDataSource(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
        simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("Route")
                .usingGeneratedKeyColumns("id")
                .usingColumns("routefrom", "routeto");
    }

    @PostConstruct
    public void postConstructor() {
        try {
            String query = "CREATE TABLE IF NOT EXISTS Route (id serial PRIMARY KEY, routefrom VARCHAR(255), routeto VARCHAR(255));";
            jdbcTemplate.update(query);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        save(new Route("Praha", "Brno"));
    }

    public List<Route> getAll() {
        return jdbcTemplate.query("SELECT * FROM Route ORDER BY 1", new RouteMapper());
    }

    @Override
    public void save(Route route) {
        if (route.getId() == 0) {
            BeanPropertySqlParameterSource source = new BeanPropertySqlParameterSource(route);
            simpleJdbcInsert.executeAndReturnKey(source);
        } else {
            String query = "UPDATE Route " +
                    "SET from = ?, to = ?, driver_id = ?, vehicle_id = ? " +
                    "WHERE id = ?";
            jdbcTemplate.update(query,
                    route.getRoutefrom(),
                    route.getRouteto(),
                    route.getDriver() != null ? route.getDriver().getId() : null,
                    route.getVehicle() != null ? route.getVehicle().getId() : null,
                    route.getId());
        }
    }

    @Override
    public void delete(Route route) {
        String query = "DELETE FROM Route WHERE id = ?";
        jdbcTemplate.update(query,
                new Object[] {route.getId()});
    }

    @Override
    public Route find(long id) {
       if (id == 0)
            return null;
        String query = "SELECT * FROM Route WHERE id = ?";
        List<Route> result = jdbcTemplate.query(query, new RouteMapper(),
                new Object[] {id});
        return !result.isEmpty() ? result.get(0) : null;
    }

    @Override
    public Route getVehicle(long vehicle) {
        if (vehicle == 0)
            return null;
        String query = "SELECT * FROM Route WHERE vehicle_id = ?";
        List<Route> result = jdbcTemplate.query(query, new RouteMapper(),
                new Object[] {vehicle});
        return !result.isEmpty() ? result.get(0) : null;
    }

    @Override
    public Route getDriver(long driver) {
        if (driver == 0)
            return null;
        String query = "SELECT * FROM Route WHERE driver_id = ?";
        List<Route> result = jdbcTemplate.query(query, new RouteMapper(),
                new Object[] {driver});
        return !result.isEmpty() ? result.get(0) : null;
    }
}
