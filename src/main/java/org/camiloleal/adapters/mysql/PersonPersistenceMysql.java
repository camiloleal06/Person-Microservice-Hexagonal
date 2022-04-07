package org.camiloleal.adapters.mysql;

import java.util.List;
import java.util.stream.Collectors;

import org.camiloleal.domain.exceptions.BadRequestException;
import org.camiloleal.domain.exceptions.NotFoundException;
import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.out_port.PersonPersistence;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class PersonPersistenceMysql implements PersonPersistence {

    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() throws NotFoundException {
        return personRepository.findAll().stream().map(PersonEntity::toPerson).collect(Collectors.toList());
    }

    @Override
    public Person create(Person person) throws BadRequestException {
        return personRepository.save(new PersonEntity(person)).toPerson();
    }

    @Override
    public Person getPersonById(Integer id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe la persona con ID " + id)).toPerson();
    }

    @Override
    public Person getPersonByEmail(String email) {
        return personRepository.findPersonByEmail(email)
                .orElseThrow(() -> new NotFoundException("No existe la persona con email : " + email));
    }

    @Override
    public void deletePersonById(Integer id) {
        if (this.getPersonById(id) != null) {
            personRepository.deleteById(id);
        }
    }

    @Override
    public Person updatePersonById(Integer id, Person person) {
        if (this.getPersonById(id) != null)
            return personRepository.save(new PersonEntity(person)).toPerson();
        else
            throw new NotFoundException("No existe la Persona con ID : " + id);
    }
}
