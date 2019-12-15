package com.vsb.vea.project.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.thymeleaf.util.StringUtils;

@Controller
public abstract class BaseController {

    protected String redirect(Model model, String content) {
        model.addAttribute("content", StringUtils.concat("/fragments/", content));
        return "layout";
    }

    @ExceptionHandler(value = Throwable.class)
    protected String handleError(Throwable ex, Model model) {
        model.addAttribute("exception", ex.getMessage());
        return redirect(model, "error");
    }
}
