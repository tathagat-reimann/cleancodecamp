package com.cleancodecamp.async.service;

public interface CoffeeService {
	/**
	 * Need to
	 * 1. Grind the beans into powder
	 * 2. Put the powder in the machine and start
	 * @param numberOfCoffees - number of coffees to be brewed
	 */
	void brewCoffee(int numberOfCoffees) throws Exception;
}
