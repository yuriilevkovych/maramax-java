package com.maramax.admin.controllers;

import com.maramax.admin.models.User;
import com.maramax.admin.models.UserDto;
import com.maramax.admin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/admin/index")
    public String home(){
        return "admin/index";
    }

    @GetMapping("/admin/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);

        return "admin/register";
    }

    @PostMapping("/admin/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto,
                               BindingResult result,
                               Model model){
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            result.rejectValue("email", null,
                    "There is already an account registered with the same email");
        }

        if(result.hasErrors()){
            model.addAttribute("user", userDto);

            return "/admin/register";
        }

        userService.saveUser(userDto);

        return "redirect:/admin/register?success";
    }

    @GetMapping("/admin/users")
    public String users(Model model){
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);

        return "admin/users";
    }

    @GetMapping("/admin/login")
    public String login(){
        return "admin/login";
    }
}