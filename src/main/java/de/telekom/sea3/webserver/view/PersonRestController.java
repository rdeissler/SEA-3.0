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
			this.personService = personService;
	}

		
		@GetMapping("/allpersons")
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
	
}
