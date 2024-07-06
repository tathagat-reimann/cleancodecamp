package com.cleancodecamp.async.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cleancodecamp.async.MyAsyncUncaughtExceptionHandler;

@SpringBootTest
public class DishwasherServiceTest {
	
	@Autowired
	private DishwasherService testee;
	
	@Test
	public void testStartDishwasher() throws Exception {
		// given
		
		// when
		testee.startDishwasher();
		
		// then
		Thread.sleep(1000l); // wait for the other thread to finish
		
		Map<String, Throwable> thrownExceptions = 
				MyAsyncUncaughtExceptionHandler.getThrownExceptions();
		Throwable exception = thrownExceptions.get("startDishwasher");
		assertTrue(exception instanceof RuntimeException);
		assertEquals("why not?", exception.getMessage()); 
	}
}
