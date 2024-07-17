package com.cleancodecamp.autowire.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.cleancodecamp.autowire.BaseTest;
import com.cleancodecamp.autowire.persistence.Person;
import com.cleancodecamp.autowire.persistence.PersonRepository;

public class PersonServiceTest extends BaseTest {
	@Autowired
	@Qualifier("personServiceImpl")
	private PersonService testee;
	
	@Autowired
	private PersonRepository personRepository;
	
	@Test
	public void shouldAutowire() throws Exception {
		assertNotNull(testee);
	}
	
	private Person person;
	
	@BeforeEach
    void setUp() {
        person = new Person();
        person.setName("old name");
        personRepository.save(person);
    }
	
	@Test
    void testUpdatePersonNameSuccessful() {
		// given
		Long id = person.getId();
		
		// when
		String newName = "new name";
        testee.updatePersonName(id, newName);

        
        // then
        Person personAfterUpdate = personRepository.findById(id).get();
        
        assertEquals(newName, personAfterUpdate.getName());
    }
}
