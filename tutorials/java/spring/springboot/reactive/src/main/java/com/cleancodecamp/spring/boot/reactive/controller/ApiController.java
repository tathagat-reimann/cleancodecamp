package com.cleancodecamp.spring.boot.reactive.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/accounts")
    public List<String> home(Model model) {
        return Arrays.asList("first", "second");
    }

}
