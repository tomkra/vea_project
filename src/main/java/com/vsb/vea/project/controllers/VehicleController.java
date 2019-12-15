package com.vsb.vea.project.controllers;

import com.vsb.vea.project.bussinesslayer.PersonService;
import com.vsb.vea.project.bussinesslayer.VehicleService;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class VehicleController extends BaseController {
    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private PersonService personService;

    private VehicleController() {
    }

    @GetMapping("/vehicles")
    public String listVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return redirect(model, "vehicles");
    }

    @RequestMapping("/vehicle/save")
    public String savePerson(@Valid @ModelAttribute Vehicle vehicle, BindingResult bindingResult, Model model, HttpServletResponse response) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("vehicle", vehicle);
            model.addAttribute("persons", personService.getAllPersons());
            return redirect(model, "vehicle_form");
        }
        vehicleService.saveChanges(vehicle);
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        try {
            response.sendRedirect("/vehicles");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return redirect(model, "vehicles");
    }

    @GetMapping("/vehicle/new")
    public String saveVehicle(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        model.addAttribute("persons", personService.getAllPersons());
        return redirect(model, "vehicle_form");
    }

    @GetMapping("/vehicle/edit/{id}")
    public String editVehicle(@PathVariable long id, Model model) {
        model.addAttribute("vehicle", vehicleService.find(id));
        model.addAttribute("persons", personService.getAllPersons());
        return redirect(model, "vehicle_form");
    }

    @GetMapping("/vehicle/delete/{id}")
    public String deleteVehicle(@PathVariable long id, Model model, HttpServletResponse response) {
        vehicleService.deleteVehicle(vehicleService.find(id));
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        try {
			response.sendRedirect("/vehicles");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return redirect(model, "vehicles");
    }
}
