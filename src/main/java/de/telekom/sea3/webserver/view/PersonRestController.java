package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonRestController { // View

	
	private PersonService personService;

	@Autowired
	public PersonRestController(PersonService personService) {
		super(); 
	//	this.getAllPersons();
			this.personService = personService;
	}

		
		@GetMapping("/json/persons/all") /**  @see URL: <a href= "http//localhost:8080/json/persons/all">URL</a> Kommentar */
		@ResponseBody 
		public String getAllPersons() { 
			Personen personen = personService.getAllPersons();
	//		personen.toJson();
			String string1 = "{\n"
					+ "	\"personen\": [\n"
					+ "		{\n"
					+ "			\"vorname\": \"Paula\",\n"
					+ "			\"nachname\": \"Meisen\",\n"
					+ "			\"anrede\": \"Frau\"\n"
					+ "		},\n"
					+ "		{\n"
					+ "			\"vorname\": \"Paul\",\n"
					+ "			\"nachname\": \"Paulsen\",\n"
					+ "			\"anrede\": \"Herr\"\n"
					+ "		},\n"
					+ "		{\n"
					+ "			\"vorname\": \"Mike\",\n"
					+ "			\"nachname\": \"Lienen\",\n"
					+ "			\"anrede\": \"Herr\"\n"
					+ "		}\n"
					+ "	]\n"
					+ "}";
			return string1;
		}
		
		
		@GetMapping("/json/persons/size") /**  @see URL: <a href= "http//localhost:8080/json/persons/all">URL</a> Kommentar */
		@ResponseBody 
		public String getSize() { 
			int size = personService.getSize();
	//		personen.toJson();
			String string1 = String.format("{\n"
					+ "	\"size\": %d \n"
					+ "}",size);
			return string1;
		}
	
}
