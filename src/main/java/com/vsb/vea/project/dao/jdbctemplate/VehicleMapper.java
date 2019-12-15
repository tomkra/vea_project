package com.vsb.vea.project.dao.jdbctemplate;

import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleMapper implements RowMapper<Vehicle> {

    @Override
    public Vehicle mapRow(ResultSet rs, int i) throws SQLException {
        Vehicle v = new Vehicle();
//        if (rs.getString("vehicle_type").equals("Car")) {
//            v = new Car();
//        } else {
//           v = new Truck();
//        }
        v.setId(rs.getLong("id"));
        v.setName(rs.getString("name"));
        v.setNumberplate(rs.getString("numberplate"));
        long driverId = rs.getLong("driver_id");
        if (driverId != 0) {
            Person driver = new Person();
            driver.setId(rs.getLong("driver_id"));
            v.setDriver(driver);
        }
        return v;
    }
}
