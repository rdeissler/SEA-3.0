package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
import de.telekom.sea3.webserver.service.PersonService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class PersonRestController { // View   --> liefert json Daten aus wegen @RestController

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
	public Long getSize() {
		return personService.getSize() ;
	}

	@GetMapping("/json/person/{id}") // {id} anstelle einer festen ID z.B. 42
	public Person getPerson(@PathVariable("id") Long id) {
		return personService.get(id);
	}

	@PostMapping("/json/person")  //
	public Person addPerson(@RequestBody Person person) {
		return personService.add(person);
	}

	@DeleteMapping("/json/person/{id}")	// {id} anstelle einer festen ID z.B. 42
	public Person delPerson(@PathVariable("id") Long id) {
		return personService.del(id);
	}
	
	@PutMapping("/json/person")	
	public Person updatePerson(@RequestBody Person person) {
		return personService.update(person);
	}
	
	
	
	@GetMapping("/json/select")
	public Personen searchNachOrt(@RequestParam(name="ort", required=false) String ort) {
		Personen personen = personService.selectPersonen(ort);
//		logger.info("Ort: " + ort);
		return personen;
	}
	
//	@DeleteMapping("/json/persons/all")
//	public Personen deleteAllPersons() {
//		Personen personen = personService.deleteAllPersons();
//		return personen;
//	}
//	@DeleteMapping("/json/persons/all")
//	public boolean deleteAllPersons() {
//		boolean result = personService.deleteAllPersons();
//		return result;
//	}
}
//CREATE TABLE persons ( ID BIGINT primary key, ANREDE VARCHAR(10), VORNAME VARCHAR(20), NACHNAME VARCHAR(20), STR VARCHAR(40), HAUSNR VARCHAR(5), PLZ VARCHAR(5), ORT VARCHAR(20), EMAIL VARCHAR(40));