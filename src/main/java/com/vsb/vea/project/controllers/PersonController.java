package com.vsb.vea.project.controllers;

import com.vsb.vea.project.bussinesslayer.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController extends BaseController {
    @Autowired
    private PersonService personService;

    public PersonController() {}

    @GetMapping("/persons")
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return redirect(model, "persons");
    }
}
