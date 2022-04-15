package org.camiloleal.domain.service;

import java.util.List;

import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.in_port.PersonInterface;
import org.camiloleal.ports.out_port.PersonPersistence;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonInterface {

    private PersonPersistence personPersistence;

    @Override
    public List<Person> findAll() {
        return personPersistence.findAll();
    }

    @Override
    public Person create(Person person) {
        return personPersistence.create(person);
    }

    @Override
    public Person getPersonById(Integer id) {
        return personPersistence.getPersonById(id);
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personPersistence.getPersonByEmail(email);
    }

    @Override
    public void deletePersonById(Integer id) {
        personPersistence.deletePersonById(id);
    }

    @Override
    public Person updatePersonById(Integer id, Person person) {
        return personPersistence.updatePersonById(id, person);
    }

    @Override
    public List<Person> findAllByContainsFistName(String firstName) {
        return personPersistence.findAllByContainsFistName(firstName);
    }

}
