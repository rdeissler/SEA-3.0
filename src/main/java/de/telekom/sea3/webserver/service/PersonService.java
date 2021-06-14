package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		super();
		System.out.println("PersonService instanziert inPS " + this.toString() + "  plus  " + this.hashCode());
		System.out.println("PersonRepository inPS " + personRepository.toString());
		this.personRepository = personRepository;
	}

}
