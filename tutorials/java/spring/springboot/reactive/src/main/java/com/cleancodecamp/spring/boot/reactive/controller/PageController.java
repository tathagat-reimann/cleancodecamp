package com.cleancodecamp.spring.boot.reactive.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Hello, World X!");
        return "home";
    }

    @GetMapping("/js/bundle.js")
    @ResponseBody
    public Resource getBundle() {
        return new ClassPathResource("static/js/bundle.js");
    }
}