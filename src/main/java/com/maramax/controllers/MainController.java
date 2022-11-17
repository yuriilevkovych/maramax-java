package com.maramax.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Main Page");
        model.addAttribute("style", "/css/index.min.css");
        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("title", "About Page");
        model.addAttribute("style", "/css/about.css");
        model.addAttribute("script", "/js/about.min.js");
        return "about";
    }

    @GetMapping("/publications")
    public String publications(Model model) {
        model.addAttribute("title", "Publications Page");
        //todo to add if empty
        model.addAttribute("style", "/css/publications.min.css");
        return "publications";
    }

    @GetMapping("/vacancies")
    public String vacancies(Model model) {
        model.addAttribute("title", "Vacancies Page");
        model.addAttribute("style", "/css/vacancies.css");
        model.addAttribute("script", "/js/vacancies.min.js");
        return "vacancies";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("title", "contact Page");
        model.addAttribute("style", "/css/contact.min.css");
        return "contact";
    }
}
