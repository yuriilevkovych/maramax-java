package com.maramax.controllers;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Main Page");
        model.addAttribute("style", "/css/index.min.css");

        return "home";
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("callback", new Callback());
        model.addAttribute("uploadPath", uploadPath);
        model.addAttribute("title", "About Page");
        model.addAttribute("style", "/css/about.css");
        model.addAttribute("script", "/js/about.min.js");

        return "about";
    }

    @GetMapping("/career")
    public String vacancies(Model model) {
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Vacancies Page");
        model.addAttribute("style", "/css/vacancies.css");
        model.addAttribute("script", "/js/vacancies.min.js");
        model.addAttribute("callback", new Callback());

        return "/career";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "contact Page");
        model.addAttribute("style", "/css/contact.css");

        return "contact";
    }
}
