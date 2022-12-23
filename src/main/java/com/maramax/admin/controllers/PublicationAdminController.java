package com.maramax.admin.controllers;

import com.maramax.publication.Publication;
import com.maramax.publication.PublicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/publication")
public class PublicationAdminController {
    @Autowired
    private PublicationRepository publicationRepository;

    @GetMapping
    public String publications(Model model) {
        model.addAttribute("publications", publicationRepository.findAll());

        return "admin/publication/index";
    }

    @GetMapping("create")
    public String createPublication(Publication publication) {
        return "admin/publication/create";
    }

    @PostMapping("create")
    public String create(@Valid Publication publication, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/admin/publication/create";
        }

//        publication.setSlug(SlugService.makeSlug(publication.getTitle()));
        //Todo slug unique
        publicationRepository.save(publication);

        return "redirect:/admin/publication";
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable(value = "id") Long id, Model model) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid publication Id:" + id));

        model.addAttribute("publication", publication);

        return "admin/publication/update";
    }

    @PostMapping("update/{id}")
    public String update(@PathVariable(value = "id") Long id, @Valid Publication publication,
                         BindingResult result, Model model) {
        if (result.hasErrors()) {
            publication.setId(id);

            return "admin/publication/edit";
        }

        publicationRepository.save(publication);

        return "redirect:/admin/publication";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid publication Id:" + id));

        publicationRepository.delete(publication);

        return "redirect:/admin/publication";
    }
}
