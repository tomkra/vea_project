package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Route;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RouteMapper implements RowMapper<Route> {

    @Override
    public Route mapRow(ResultSet rs, int i) throws SQLException {
        Route r = new Route();
        r.setId(rs.getLong("id"));
        r.setRoutefrom(rs.getString("routefrom"));
        r.setRouteto(rs.getString("routeto"));
        long driverId = rs.getLong("driver_id");
        if (driverId != 0) {
            Person driver = new Person();
            driver.setId(rs.getLong("driver_id"));
            r.setDriver(driver);
        }

        long vehicleId = rs.getLong("vehicle_id");
        if (vehicleId != 0) {
            Vehicle vehicle = new Vehicle();
            vehicle.setId(rs.getLong("vehicle_id"));
            r.setVehicle(vehicle);
        }
        return r;
    }
}
