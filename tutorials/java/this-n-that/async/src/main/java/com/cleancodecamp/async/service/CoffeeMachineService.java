package com.cleancodecamp.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;

public interface CoffeeMachineService {
	@Async
	CompletableFuture<Void> makeCoffee(String coffeePowder);
}
