package com.cleancodecamp.jacoco.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class GreetingServiceTest {
	@Test
	public void testSayHello() throws Exception {
		// given
		GreetingService greetingService = new GreetingServiceImpl();
		String name = "Josh";
		
		// when
		String reply = greetingService.sayHello(name);
		
		// then
		assertEquals("Hello Josh!", reply);
	}
	
	@Test
	public void testSayHello_blank() throws Exception {
		// given
		GreetingService greetingService = new GreetingServiceImpl();
		String name = "";
		
		// when / then
		IllegalArgumentException thrownException = 
				assertThrows(IllegalArgumentException.class, () -> greetingService.sayHello(name));
		
		assertEquals("name must be provided!", thrownException.getMessage());
	}
}
