package com.maramax.controllers;

import com.maramax.callback.Callback;
import com.maramax.service.YearsLeadingCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Year;

@Controller
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("callback", new Callback());
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("yearsLeading", YearsLeadingCalculator.calculate());
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        model.addAttribute("style", "/css/index.css");

        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("uploadPath", uploadPath);
        model.addAttribute("title", "About Page");
        model.addAttribute("style", "/css/about.css");
        model.addAttribute("script", "/js/about.min.js");

        return "about";
    }

    //Todo delete it
    @GetMapping("/career_old")
    public String career(Model model) {
        model.addAttribute("title", "Career Old Page");
        model.addAttribute("style", "/css/vacancies.css");
        model.addAttribute("script", "/js/vacancies.min.js");

        return "career_old";
    }
}
