package com.cleancodecamp.togglz_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FooController {
	
	@GetMapping("/foo")
	public String get() {
		return "FOO";
	}
}
