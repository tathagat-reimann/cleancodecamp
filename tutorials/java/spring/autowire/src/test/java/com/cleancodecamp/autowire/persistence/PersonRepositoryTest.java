package com.cleancodecamp.autowire.persistence;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.cleancodecamp.autowire.BaseTest;

public class PersonRepositoryTest extends BaseTest {
	@Autowired
	private PersonRepository testee;
	
	@Test
	public void shouldAutowire() throws Exception {
		assertNotNull(testee);
	}
}
