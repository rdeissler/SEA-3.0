package de.telekom.sea3.webserver.repo;

import org.springframework.stereotype.Repository;

@Repository // erzeugt new PersonRepository
public class PersonRepository {   // get set Person

	public PersonRepository() {
		super();
		System.out.println("PersonRepository instanziert inPR " + this.toString() + "  plus  " + this.hashCode());
	}

	public int getSize() {
		return 0;
	}

}
