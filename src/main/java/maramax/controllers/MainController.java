package maramax.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        //todo to add if empty
        model.addAttribute("style", "/css/about.min.css");
        model.addAttribute("script", "/js/about.min.js");
        return "about";
    }
}
