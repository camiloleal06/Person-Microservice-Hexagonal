package org.camiloleal.ports.out_port;

import java.util.List;

import org.camiloleal.domain.model.Person;

public interface PersonPersistence {

    List<Person> findAll();

    Person create(Person person);

    Person getPersonById(Integer id);

    Person getPersonByEmail(String email);

    void deletePersonById(Integer id);

    Person updatePersonById(Integer id, Person person);

    List<Person> findAllByContainsFistName(String firstName);

}
