package com.maramax.admin.controllers;

import com.maramax.admin.models.User;
import com.maramax.admin.models.UserDto;
import com.maramax.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @GetMapping("{id}")
    public String update(@PathVariable("id") long id, Model model) {
        User user = this.userService.findById(id).get();
        user.setPassword("***");
        model.addAttribute("user", user);

        return "admin/user/update";
    }

    @PostMapping("{id}")
    public String update(@Valid @ModelAttribute("user") UserDto userDto) {
        userService.updateUser(userDto);

        return "redirect:/admin/user/" + userDto.getId() + "?success";
    }
}
