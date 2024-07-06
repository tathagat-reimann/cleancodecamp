package com.cleancodecamp.async.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoffeeServiceTest {
	@Autowired
	private CoffeeServiceImpl testee;
	
	@Test
	public void testAutowire() {
		assertNotNull(testee);
	}
	
	@Test
	public void testBrewCoffee() throws Exception {
		// given
		int numberOfCoffees = 10;
		
		// when
		testee.brewCoffee(numberOfCoffees);
		
		// then - output time taken
	}
}
