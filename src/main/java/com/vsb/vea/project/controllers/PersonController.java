package com.vsb.vea.project.controllers;

import com.vsb.vea.project.bussinesslayer.PersonService;
import com.vsb.vea.project.dto.Person;
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
public class PersonController extends BaseController {
    @Autowired
    private PersonService personService;

    public PersonController() {}

    @GetMapping("/persons")
    public String listPersons(Model model) {
        model.addAttribute("persons", personService.getAllPersons());
        return redirect(model, "persons");
    }

    @RequestMapping("/person/save")
    public String savePerson(@Valid @ModelAttribute Person person, BindingResult bindingResult, Model model, HttpServletResponse response) {
        if(bindingResult.hasErrors()) {
            model.addAttribute("person", person);
            return redirect(model, "person_form");
        }
        personService.saveChanges(person);
        model.addAttribute("persons", personService.getAllPersons());
        try {
            response.sendRedirect("/persons");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return redirect(model, "persons");
    }

    @GetMapping("/person/new")
    public String addPerson(Model model) {
        model.addAttribute("person", new Person());
        return redirect(model, "person_form");
    }

    @GetMapping("/person/edit/{id}")
    public String editPerson(@PathVariable long id, Model model) {
        model.addAttribute("person", personService.find(id));
        return redirect(model, "person_form");
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable long id, Model model, HttpServletResponse response) {
        personService.deletePerson(personService.find(id));
        model.addAttribute("persons", personService.getAllPersons());
        try {
			response.sendRedirect("/persons");
		} catch (IOException e) {
			e.printStackTrace();
		}
        return redirect(model, "persons");
    }

}
