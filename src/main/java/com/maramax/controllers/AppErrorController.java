package com.maramax.controllers;

import com.maramax.callback.Callback;
import com.maramax.service.YearsLeadingCalculator;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.Year;

@Controller
public class AppErrorController implements ErrorController {
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("callback", new Callback());
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("yearsLeading", YearsLeadingCalculator.calculate());
    }

    @RequestMapping("/error")
    public String handleError() {
        //do something like logging
        return "error";
    }
}