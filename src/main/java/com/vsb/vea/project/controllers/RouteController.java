package com.vsb.vea.project.controllers;

import com.vsb.vea.project.bussinesslayer.PersonService;
import com.vsb.vea.project.bussinesslayer.RouteService;
import com.vsb.vea.project.bussinesslayer.VehicleService;
import com.vsb.vea.project.dto.Route;
import com.vsb.vea.project.dto.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class RouteController extends BaseController {
    @Autowired
    private RouteService routeService;

    @Autowired
    private VehicleService vehicleService;

    @Autowired
    private PersonService personService;

    public RouteController() {}

    @GetMapping("/routes")
    public String listRoutes(Model model) {
        model.addAttribute("routes", routeService.getAllRoutes());
        return redirect(model, "routes");
    }

    @GetMapping("/route/save")
    public String saveRoute(@Valid @ModelAttribute Route route, BindingResult bindingResult, Model model, HttpServletResponse response) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("route", route);
            model.addAttribute("persons", personService.getAllPersons());
            model.addAttribute("vehicles", vehicleService.getAllVehicles());
            return redirect(model, "vehicle_form");
        }
        routeService.saveChanges(route);
        model.addAttribute("routes", routeService.getAllRoutes());
        try {
            response.sendRedirect("/routes");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return redirect(model, "routes");
    }

    @GetMapping("/route/new")
    public String addRoute(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("route", new Route());
        return redirect(model, "route_form");
    }


    @GetMapping("/route/edit/{id}")
    public String editRoute(@PathVariable long id, Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        model.addAttribute("persons", personService.getAllPersons());
        model.addAttribute("route", routeService.find(id));
        return redirect(model, "route_form");
    }

    @GetMapping("/route/delete/{id}")
    public String deleteRoute(@PathVariable long id, Model model, HttpServletResponse response) {
        routeService.deleteRoute(routeService.find(id));
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        model.addAttribute("persons", personService.getAllPersons());
        try {
			response.sendRedirect("/routes");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return redirect(model, "routes");
    }




}
