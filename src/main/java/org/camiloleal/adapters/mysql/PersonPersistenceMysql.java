package org.camiloleal.adapters.mysql;

import java.util.List;

import org.camiloleal.adapters.mysql.mapper.PersonEntityMapper;
import org.camiloleal.domain.exceptions.BadRequestException;
import org.camiloleal.domain.exceptions.ConflictException;
import org.camiloleal.domain.exceptions.NotFoundException;
import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.out_port.PersonPersistence;
import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class PersonPersistenceMysql implements PersonPersistence {

    private PersonRepository personRepository;
    private PersonEntityMapper mapper;

    private void assertNoExistByEmailOrDni(String email, String dni) {
        if (this.personRepository.findPersonByEmail(email).isPresent()) {
            throw new ConflictException("The EMAIL already exists: " + email);
        }
        if (this.personRepository.findPersonByDni(dni).isPresent()) {
            throw new ConflictException("The DNI already exists: " + dni);
        }
    }

    @Override
    public List<Person> findAll() throws NotFoundException {
        return mapper.toListPerson(personRepository.findAll());
    }

    @Override
    public Person create(Person person) throws BadRequestException {
        this.assertNoExistByEmailOrDni(person.getEmail(), person.getDni());
        return mapper.toPerson(personRepository.save(mapper.toEntity(person)));
    }

    @Override
    public Person getPersonById(Integer id) {
        return mapper.toPerson(personRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No existe la persona con ID " + id)));
    }

    @Override
    public Person getPersonByEmail(String email) {
        return mapper.toPerson(personRepository.findPersonByEmail(email)
                .orElseThrow(() -> new NotFoundException("No existe la persona con email : " + email)));
    }

    @Override
    public void deletePersonById(Integer id) {
        if (this.getPersonById(id) != null) {
            personRepository.deleteById(id);
        }
    }

    @Override
    public Person updatePersonById(Integer id, Person person) {
        if (this.getPersonById(id) != null) {
            return mapper.toPerson(personRepository.save(mapper.toEntity(person)));
        } else {
            throw new NotFoundException("No existe la Persona con ID : " + id);
        }
    }

    @Override
    public List<Person> findAllByContainsFistName(String firstName) {
        List<Person> result = mapper.toListPerson(personRepository.findByFirstNameContains(firstName));
        if (result.isEmpty()) {
            throw new NotFoundException("No se han encontrado Personas");
        } else {
            return result;
        }
    }

}
