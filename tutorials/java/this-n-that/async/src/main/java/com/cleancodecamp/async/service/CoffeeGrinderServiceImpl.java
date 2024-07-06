package com.cleancodecamp.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;

@Component
public class CoffeeGrinderServiceImpl implements CoffeeGrinderService {

	@Override
	public CompletableFuture<String> grindCoffeeBeans() {
		try {
			Thread.sleep(200l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture("coffee powder");
	}

}
