package com.cleancodecamp.async.service;

import org.springframework.scheduling.annotation.Async;

public interface DishwasherService {
	@Async
	void startDishwasher();
}
