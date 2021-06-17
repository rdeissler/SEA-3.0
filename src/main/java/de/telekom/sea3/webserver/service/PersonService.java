package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public int getSize() {
		return personRepository.getSize();
	}

	public Personen getAllPersons() {
		return new Personen(personRepository.getAll());   //Wrapper wird für json benötigt
	}

	public Person get(int id) {
		return new Person( "id",  "anrede", "vorname",  "nachname",   "str",  "hausNr",  "plz",
				 "ort",  "email");
	}

	public Person add(Person person) {
		personRepository.add(person);
		System.out.println("Person wurde angelegt: " +person.toString());
		return person;
	}

	public Person del(String id) {
		personRepository.del(id);
		System.out.println("Person wurde gelöscht");
		return null;
	}
	
	public Person update(Person person) {
		personRepository.update(person);
		System.out.println("Person wurde geändert");
		return null;
	}
	
/*	public Personen deleteAllPersons() {
		return new Personen(personRepository.deleteAll()); 
	} */
}
