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
        model.addAttribute("style", "/css/about.min.css");
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

    @GetMapping("/products/pos-materials")
    public String productsPosMaterials(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/pos-materials.html";
    }

    @GetMapping("/products/cashed")
    public String productsCashed(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/cashed.html";
    }

    @GetMapping("/products/cartboard")
    public String productsCartboard(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/cartboard.html";
    }

    @GetMapping("/products/corrugated-cartboard")
    public String productsCorrugatedCartboard(Model model) {
        model.addAttribute("title", "Products Page");
        model.addAttribute("style", "/css/products.min.css");
        model.addAttribute("script", "/js/production.min.js");
        return "products/corrugated-cartboard.html";
    }
}
