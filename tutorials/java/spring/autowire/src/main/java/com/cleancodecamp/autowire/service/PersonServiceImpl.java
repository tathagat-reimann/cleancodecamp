package com.cleancodecamp.autowire.service;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.cleancodecamp.autowire.persistence.Person;
import com.cleancodecamp.autowire.persistence.PersonRepository;

@Component
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;

	private DummyServiceImpl dummyServiceImpl;

	public PersonServiceImpl(PersonRepository personRepository, DummyServiceImpl dummyServiceImpl) {
		this.personRepository = personRepository;
		this.dummyServiceImpl = dummyServiceImpl;
	}

	@Override
	public void updatePersonName(Long id, String newName) {
		Optional<Person> personSearchResult = personRepository.findById(id);
		
		if (personSearchResult.isEmpty()) {
			throw new IllegalArgumentException(String.format("Person with ID %s not found", id));
		}
		Person person = personSearchResult.get();
		person.setName(newName);
		
		personRepository.save(person);
	}

}
