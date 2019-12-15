package com.vsb.vea.project.converters;

import com.vsb.vea.project.dao.DaoFactory;
import com.vsb.vea.project.dao.VehicleDao;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class VehicleConverter implements Converter<String, Vehicle> {
    private VehicleDao vehicleDao;

    public VehicleConverter(DaoFactory daoFactory) {
        vehicleDao = daoFactory.getVehicleDao();
    }

    @Override
    public Vehicle convert(String s) {
        if(s == null || s.isEmpty() || "null".equals(s)) {
            return null;
        }
        return vehicleDao.find(Long.parseLong(s));
    }
}
