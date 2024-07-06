package com.cleancodecamp.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Component;

@Component
public class CoffeeMachineServiceImpl implements CoffeeMachineService {

	@Override
	public CompletableFuture<Void> makeCoffee(String coffeePowder) {
		try {
			Thread.sleep(200l);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(null);
	}

}
