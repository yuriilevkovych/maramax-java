package com.maramax.admin.controllers;

import com.maramax.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String index(Model model){
        model.addAttribute("users", userService.findAllUsers());

        return "/admin/user/index";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id, Model model) {
        this.userService.deleteById(id);

        return "redirect:/admin/user/index";
    }
}
