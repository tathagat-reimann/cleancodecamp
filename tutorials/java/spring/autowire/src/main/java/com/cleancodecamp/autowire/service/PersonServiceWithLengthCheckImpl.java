package com.cleancodecamp.autowire.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import com.cleancodecamp.autowire.persistence.Person;
import com.cleancodecamp.autowire.persistence.PersonRepository;

@Component
public class PersonServiceWithLengthCheckImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public void updatePersonName(Long id, String newName) {
		Assert.isTrue(newName.length() >= 5, "New name must be at least 5 characters long");
		Optional<Person> personSearchResult = personRepository.findById(id);
		
		if (personSearchResult.isEmpty()) {
			throw new IllegalArgumentException(String.format("Person with ID %s not found", id));
		}
		Person person = personSearchResult.get();
		person.setName(newName);
		
		personRepository.save(person);
	}

}
