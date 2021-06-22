package de.telekom.sea3.webserver.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService { // Service

	private static PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziert inPS " + this.toString() + "  plus  " + this.hashCode());
		System.out.println("PersonRepository inPS " + personRepository.toString());
		this.personRepository = personRepository;
	}

	public Long getSize() {
		return personRepository.count();
	}

	public Iterable<Person> getAllPersons() {
		return personRepository.findAll();   //Wrapper wird für json benötigt
	}

	public Optional<Person> get(Long id) {
		return personRepository.findById(id);
	}

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde angelegt: " +person.toString());
		return person;
	}

	public Person del(Long id) {
		personRepository.deleteById(id);
		System.out.println("Person wurde gelöscht");
		return null;
	}
	
	public Person update(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde geändert");
		return null;
	}

	
	
	public Person delAll(Person person) {
		personRepository.deleteAll();
		System.out.println("Alle Personen wurden gelöscht");
		return null;
	}
	
}
