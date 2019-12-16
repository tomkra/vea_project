package com.vsb.vea.project.setting;

import com.vsb.vea.project.converters.PersonConverter;
import com.vsb.vea.project.converters.VehicleConverter;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringSetting implements WebMvcConfigurer {

    @Autowired
    private PersonConverter personConverter;

    @Autowired
    private VehicleConverter vehicleConverter;

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(personConverter);
        registry.addConverter(vehicleConverter);
    }

}
