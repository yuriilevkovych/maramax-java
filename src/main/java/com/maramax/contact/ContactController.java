package com.maramax.contact;

import com.maramax.callback.Callback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.time.Year;

@Controller
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("year", Year.now().getValue());
        model.addAttribute("callback", new Callback());
    }

    @GetMapping("/contact")
    public String index(Model model) {
        model.addAttribute("contacts", this.contactRepository.findAll());
        model.addAttribute("title", "Contact Page");
        model.addAttribute("style", "/css/contact.css");

        return "contact";
    }
}
