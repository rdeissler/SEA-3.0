package de.telekom.sea3.webserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.repo.PersonRepository;

@Service
public class PersonService {  //Service

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
		return new Personen();
	}
	
}
