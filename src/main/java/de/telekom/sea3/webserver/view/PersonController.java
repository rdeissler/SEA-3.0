package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.service.PersonService;

@Controller
public class PersonController { // View

	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'> "
			+ "<head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Titel</title> </head> "
			+ "<body>size: %d </body> </html>"; // HTML Grundgerüst für eine Webseite aus dem Internet, danach size %d
												// in body eingefügt
	private PersonService personService;

	@Autowired
	public PersonController(PersonService personService) {
		super();
		System.out.println("PersonController instanziert inPC " + this.toString() + "  plus  " + this.hashCode());
		System.out.println("PersonService inPC " + personService.toString());
		this.personService = personService;
	}

	
	@GetMapping("/size") // URL:"http://localhost:8080/size)
	@ResponseBody // wir sagen Spring, dass er den Htmlbody zurückgeben soll
					// (http://localhost:8080/size, ->F12, ->size, ->Response, hier ist der Body mit
					// der Rückgabe)
	public String getSize() { // Umwandlung von Zahl in String:
		// String string1 = Integer.toString(personService.getSize()); // Möglichkeit 1
		// String string2 = String.valueOf(personService.getSize()); // Möglichkeit 2
		// String string3 = "" +personService.getSize(); // Möglichkeit 3
		// String string4 = String.format("%d", personService.getSize()); // Möglichkeit
		// 4

		// String soll nicht nur Zahl in String, sondern Zahl aus HTML in String
		// ausgeben.
		String string5 = String.format(HTMLTEMPLATE, personService.getSize()); // Möglichkeit 5
		return string5;
	}
	
}
