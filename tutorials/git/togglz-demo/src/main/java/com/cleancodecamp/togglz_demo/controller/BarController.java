package com.cleancodecamp.togglz_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.togglz.core.Feature;
import org.togglz.core.manager.FeatureManager;
import org.togglz.core.util.NamedFeature;

@RestController
public class BarController {

	private FeatureManager manager;
	public static final Feature BAR = new NamedFeature("BAR");

	public BarController(FeatureManager manager) {
		this.manager = manager;
	}

	@GetMapping("/bar")
	public String get() {
		if (manager.isActive(BAR)) {
			return "BAR";
		} else 
			throw new UnsupportedOperationException();

	}
}
