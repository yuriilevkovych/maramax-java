package com.maramax.admin.controllers;

import com.maramax.admin.models.User;
import com.maramax.admin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Map;

@Controller
public class RegistrationController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/registration")
    public String registration() {
        return "admin/registration";
    }

    @PostMapping("/admin/registration")
    public String addUser(User user, Map<String, Object> model) {
        User userFromDb = userRepository.findByUsername(user.getUsername());

        if (userFromDb != null) {
            model.put("message", "User exists!");
            return "admin/registration";
        }

        user.setActive(true);
        userRepository.save(user);

        return "redirect:/login";
    }
}
