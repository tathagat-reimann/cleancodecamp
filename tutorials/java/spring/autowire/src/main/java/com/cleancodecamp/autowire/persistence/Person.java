package com.cleancodecamp.autowire.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Person {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue
	private Long id;
	private String name;
}
