package de.telekom.sea3.webserver.repo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import de.telekom.sea3.webserver.model.Person;

@Repository // erzeugt new PersonRepository
public class PersonRepository_ohneDB { // get set Person

	private List<Person> personen = new ArrayList<Person>();

	public PersonRepository_ohneDB() {
		super();
		System.out.println("PersonRepository instanziert inPR " + this.toString() + "  plus  " + this.hashCode());
	}

	public int getSize() {
		return personen.size();
	}

	public boolean add(Person person) {
		return personen.add(person);
	}

	public List<Person> getAll() {
		return personen;
	}

	public boolean del(String id) {
		for (int i = 0; i < personen.size(); i++) {
			Person person = personen.get(i);
			if (person.getId().equals(id)) {
				personen.remove(i);
				return true;
			}
		}
		return false;
	}
	
	public boolean update(Person person) {
		for (int i = 0; i < personen.size(); i++) {
			Person person1 = personen.get(i);
			if (person1.getId().equals(person.getId())) {
				personen.set(i, person);
				return true;
			}
		}
		return false;
	}	
	
	public boolean deleteAll() {
		return personen.removeAll(personen);
				}
	
//	public List<Person> deleteAll() {
//		for (int i = 0; i < personen.size(); i++) {
//							personen.remove(i);
//		}
//		return personen;
//	} 
}