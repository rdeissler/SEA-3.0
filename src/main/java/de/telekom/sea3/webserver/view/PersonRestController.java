package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@RestController
public class PersonRestController { // View

	private PersonService personService;

	@Autowired
	public PersonRestController(PersonService personService) {
		super();
		// this.getAllPersons();
		this.personService = personService;
	}

	
	/**
	 * @see URL: <a href= "http//localhost:8080/json/persons/all">URL</a> Kommentar
	 */
	@GetMapping("/json/persons/all")
	public Personen getAllPersons() {
		Personen personen = personService.getAllPersons();
		return personen;
		// personen.toJson();
	}

	@GetMapping("/json/persons/size")
	public Integer getSize() {
		int size = personService.getSize();
		return size;
	}

}
