package de.telekom.sea3.webserver.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService { // Service

	private PersonRepository personRepository;
//	static Logger logger = LoggerFactory.getLogger(PersonService.class);
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziert inPS " + this.toString() + "  plus  " + this.hashCode());
		System.out.println("PersonRepository inPS " + personRepository.toString());
		logger.info(String.format("[INFO] Personservice instanziiert: %s", this.toString()));
		logger.info(String.format("[INFO] Personservice instanziiert: %s", this.getClass().getName()));
		logger.info(String.format("[INFO] Personservice durch Annnotation instanziiert: %s" , personRepository.toString()));
		this.personRepository = personRepository;
	}

	public Long getSize() {
		return personRepository.count();
	}

	public Personen getAllPersons() {
		Personen personen = new Personen();
		for( Person p : personRepository.findAll()) {
			personen.getPersonen().add(p);
			}
			return personen;
	}

//	public Optional<Person> get(Long id) {
//		return personRepository.findById(id);
//	}
	public Person get(Long id) {
		if (personRepository.findById(id).isPresent()) {
			return personRepository.findById(id).get();
		} else {
			return null;
		}
	}
	

	public Person add(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde angelegt: " +person.toString());
		return person;
	}

	public Person del(Long id) {
		personRepository.deleteById(id);
		logger.error(null);
		System.out.println("Person wurde gelöscht");
		return null;
	}
	
	public Person update(Person person) {
		personRepository.save(person);
		System.out.println("Person wurde geändert");
		return null;
	}

	public Personen selectPersonen() {
		Personen ps = new Personen();
		for (Person p : personRepository.selectPersonen()) {
			ps.getPersonen().add(p);
		}
		return ps;
	}

	public Personen selectPersonen(String ort) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
//	public Person delAll(Person person) {
//		personRepository.deleteAll();
//		System.out.println("Alle Personen wurden gelöscht");
//		return null;
	}
	

