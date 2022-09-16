package com.yurii.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {

    @GetMapping("/blog")
    public String blog(Model model) {
        model.addAttribute("title", "Blog Page");
        return "blog";
    }
}
