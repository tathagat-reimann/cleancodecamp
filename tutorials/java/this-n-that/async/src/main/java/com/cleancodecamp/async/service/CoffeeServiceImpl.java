package com.cleancodecamp.async.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CoffeeServiceImpl implements CoffeeService {
	
	private CoffeeGrinderService coffeeGrinderService;
	
	private CoffeeMachineService coffeeMachineService;

	private DishwasherService dishwasherService;
	
	public CoffeeServiceImpl(DishwasherService dishwasherService, CoffeeGrinderService coffeeGrinderService, CoffeeMachineService coffeeMachineService) {
		super();
		this.coffeeGrinderService = coffeeGrinderService;
		this.coffeeMachineService = coffeeMachineService;
		this.dishwasherService = dishwasherService;
	}

	@Override
	public void brewCoffee(int numberOfCoffees) throws Exception {
		long startTime = System.currentTimeMillis();
		String coffeePowder = coffeeGrinderService.grindCoffeeBeans().get();
		for (int i = 1; i <= numberOfCoffees; i++) {
			log.info("Starting number {} coffee", i);
			coffeePowder = makeCoffeeAndAtTheSameTimeGrindBeansForTheNext(coffeePowder);
		}
		long endTime = System.currentTimeMillis();
		dishwasherService.startDishwasher();
		log.info("Took {} seconds to brew {} coffees",
		 (endTime-startTime)/1000,numberOfCoffees);
	}
	
	private String makeCoffeeAndAtTheSameTimeGrindBeansForTheNext(String coffeePowder) throws Exception {
		CompletableFuture<Void> coffee = coffeeMachineService.makeCoffee(coffeePowder);
		CompletableFuture<String> powder = coffeeGrinderService.grindCoffeeBeans();
		
		CompletableFuture.allOf(coffee, powder);
		
		return powder.get();
	}
	
}
