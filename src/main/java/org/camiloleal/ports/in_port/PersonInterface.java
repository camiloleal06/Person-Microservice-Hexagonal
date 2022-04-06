package org.camiloleal.ports.in_port;

import java.util.List;

import org.camiloleal.domain.model.Person;

public interface PersonInterface {
    List<Person> findAll();

    Person create(Person person);

    Person getPersonById(Integer id);

    Person getPersonByEmail(String email);
}
