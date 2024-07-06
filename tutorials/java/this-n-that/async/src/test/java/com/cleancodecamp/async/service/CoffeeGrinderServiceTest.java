package com.cleancodecamp.async.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CoffeeGrinderServiceTest {
	@Autowired
	public CoffeeGrinderService testee;
	
	@Test
	public void testGrindCoffeeBeans() throws Exception {
		// given
		
		// when
		CompletableFuture<String> future = testee.grindCoffeeBeans();
		
		// then
		assertEquals("coffee powder", future.get()); 
	}
}
