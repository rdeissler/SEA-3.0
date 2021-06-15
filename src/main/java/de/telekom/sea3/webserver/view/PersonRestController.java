package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.model.Size;
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
	public Size getSize() {
		return new Size(personService.getSize());
	}

	@GetMapping("/json/person/{id}") // {id} anstelle einer festen ID z.B. 42
	public Person getPerson(@PathVariable("id") int id) {
		return personService.get(id);
	}

	@PostMapping("/json/person")
	public Person addPerson(@RequestBody Person person) {
		return personService.add(person);
	}

}
