package com.cleancodecamp.jacoco.service;

public interface GreetingService {
	/**
	 * Says hello to the given name.
	 * Throws {@link IllegalArgumentException} if name is null or empty.
	 * @param name
	 * @return
	 */
	String sayHello(String name);
}
