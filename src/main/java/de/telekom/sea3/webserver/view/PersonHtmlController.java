package de.telekom.sea3.webserver.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import de.telekom.sea3.webserver.model.Person;
import de.telekom.sea3.webserver.model.Personen;
import de.telekom.sea3.webserver.service.PersonService;

@Controller // Controller liefert HTML zurück, aktuell nur für die size.html
public class PersonHtmlController { // View
	// hier als konstanter String, sollte eigentlich aus der HTML-Datei kommen
	private static final String HTMLTEMPLATE = "<!DOCTYPE html> <html lang='de'> "
			+ "<head> <meta charset='utf-8'> <meta name='viewport' content='width=device-width, initial-scale=1.0'> <title>Titel</title> </head> "
			+ "<body><h1>size: %d </h1></body> </html>"; // HTML Grundgerüst für eine Webseite aus dem Internet, danach size %d
												// in body eingefügt
	private PersonService personService;

	@Autowired
	public PersonHtmlController(PersonService personService) {
		super();
		System.out.println("PersonController instanziert inPC " + this.toString() + "  plus  " + this.hashCode());
		System.out.println("PersonService inPC " + personService.toString());
		this.personService = personService;
	}

	// Dynamischer Aufbau der Webseite durch Size (%d), die während der Laufzeit
	// ermittelt wird (Anzahl der Personen)
	// URL: http//localhost:8222/size
	@GetMapping("/size")
	@ResponseBody // sagt Spring Framework, dass die Antwort in den Body gepackt werden soll und nicht über das Template.
	public String getSize() {
		String string5 = String.format(HTMLTEMPLATE, personService.getSize()); // Möglichkeit 5
		return string5;
	}
	
	// URL: http://localhost:8222/counter
	@GetMapping("/counter")
	public String htmlName(Model model,
			@RequestParam(value = "name", required = false, defaultValue = "Welt") String string
	)
	{	
		model.addAttribute("name", string);
		return "count";
	}

	// URL: http://localhost:8222/sizeanzahl
	@GetMapping("/sizeanzahl")
	public String getSize2(Model model)
	{	
		model.addAttribute("sizename", personService.getSize());
		return "size";
	}
	
	// URL: http://localhost:8222/personenliste
	@GetMapping("/personenliste") //kein ResponseBody, da ResponseBody den Weg über das Thymeleaf Template verhindert (habe schon alles)
	public String getPersonen(Model model)
	{		
		Personen personen = personService.getAllPersons();
		model.addAttribute("personenList", personen.getPersonen());
		return "personen";
	}
	
}
