package com.maramax.admin.controllers;

import com.maramax.contact.Contact;
import com.maramax.contact.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/contact")
public class ContactAdminController {
    @Autowired
    private ContactRepository contactRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("contacts", contactRepository.findAll());

        return "admin/contact/index";
    }

    @GetMapping("{id}")
    public String update(@PathVariable("id") long id, Model model) {
        Contact contact = contactRepository.findById(id).get();
        model.addAttribute("contact", contact);

        return "admin/contact/update";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("contact") @Valid Contact contact,
                         BindingResult bindingResult,
                         @PathVariable(value = "id") Long id,
                         Model model) {
        if (bindingResult.hasErrors()) {
            return "admin/contact/update";
        }

        contactRepository.save(contact);

        return "redirect:/admin/contact";
    }
}