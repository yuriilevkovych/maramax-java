package com.maramax.publication;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PublicationController {
    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping("/publications")
    public String publications(Model model) {
        model.addAttribute("publications", publicationRepository.findAll());
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Publications Page");
        //todo to add if empty
        model.addAttribute("style", "/css/publications.css");

        return "publications";
    }

    @GetMapping("/publication/{slug}")
    public String publications(@PathVariable(value = "slug") String slug, Model model) {
        if (!publicationRepository.existsBySlug(slug)) {
            return "redirect:/publications";
        }

        model.addAttribute("publication", publicationRepository.findBySlug(slug));
        model.addAttribute("callback", new Callback());
        model.addAttribute("title", "Publication Page");
        model.addAttribute("style", "/css/publications.css");

        return "publication";
    }
}
