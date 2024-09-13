package com.cleancodecamp.jacoco.service;

import io.micrometer.common.util.StringUtils;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello(String name) {
		if (StringUtils.isBlank(name))
			throw new IllegalArgumentException("name must be provided!");
		return "Hello " + name + "!";
	}

}
