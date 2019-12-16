package com.vsb.vea.project.controllers.rest;

import com.vsb.vea.project.bussinesslayer.RouteService;
import com.vsb.vea.project.dto.Person;
import com.vsb.vea.project.dto.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteRestController {
    public RouteRestController() {}

    @Autowired
    private RouteService routeService;

    @RequestMapping("/rest/routes")
    public List<Route> getAll() {
        return routeService.getAllRoutes();
    }

    @RequestMapping("/rest/route/{id}")
    public Route getRoute(@PathVariable long id) {
        return routeService.find(id);
    }
}