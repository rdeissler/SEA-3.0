package de.telekom.sea3.webserver.repo;

import org.springframework.data.repository.CrudRepository;

import de.telekom.sea3.webserver.model.Person;

public interface PersonRepository extends CrudRepository<Person,Long> {

}
