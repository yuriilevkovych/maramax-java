package com.maramax.publication;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.Year;

@Controller
public class PublicationController {
    @Autowired
    private PublicationRepository publicationRepository;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("callback", new Callback());
    }

    @GetMapping("/publications")
    public String publications(Model model) {
        model.addAttribute("publications", publicationRepository.findAll());
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
        model.addAttribute("title", "Publication Page");
        model.addAttribute("style", "/css/publications.css");

        return "publication";
    }
}
