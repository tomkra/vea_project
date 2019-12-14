package com.vsb.vea.project.controllers;

import com.vsb.vea.project.bussinesslayer.PersonService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
    private PersonService personService;
}
