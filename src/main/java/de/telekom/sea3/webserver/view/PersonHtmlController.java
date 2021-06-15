package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonHtmlController { // View

	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'> "
			+ "<head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Titel</title> </head> "
			+ "<body>size: %d </body> </html>"; // HTML Grundgerüst für eine Webseite aus dem Internet, danach size %d
												// in body eingefügt
	private PersonService personService;

	@Autowired
	public PersonHtmlController(PersonService personService) {
		super();
		System.out.println("PersonController instanziert inPC " + this.toString() + "  plus  " + this.hashCode());
		System.out.println("PersonService inPC " + personService.toString());
		this.personService = personService;
	}

	
	@GetMapping("/size") 
	@ResponseBody
	public String getSize() { 
		String string5 = String.format(HTMLTEMPLATE, personService.getSize()); // Möglichkeit 5
		return string5;
	}
	
}
