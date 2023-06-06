package com.maramax.admin.controllers;

import com.maramax.page.Page;
import com.maramax.page.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/page")
public class PageAdminController {
    @Autowired
    private PageRepository pageRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("pages", pageRepository.findAll());

        return "admin/page/index";
    }

    @GetMapping("{id}")
    public String update(@PathVariable("id") long id, Model model) {
        Page page = pageRepository.findById(id).get();
        model.addAttribute("page", page);

        return "admin/page/update";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("page") @Valid Page page,
                         BindingResult bindingResult,
                         @PathVariable(value = "id") Long id,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/page/update";
        }

        pageRepository.save(page);

        return "redirect:/admin/page/" + id;
    }
}