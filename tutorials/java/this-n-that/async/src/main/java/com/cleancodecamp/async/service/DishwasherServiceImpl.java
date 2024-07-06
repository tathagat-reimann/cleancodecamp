package com.cleancodecamp.async.service;

import org.springframework.stereotype.Component;

@Component
public class DishwasherServiceImpl implements DishwasherService {

	@Override
	public void startDishwasher() {
		throw new RuntimeException("why not?");
	}

}
