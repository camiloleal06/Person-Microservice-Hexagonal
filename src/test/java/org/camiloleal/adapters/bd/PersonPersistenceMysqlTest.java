package org.camiloleal.adapters.bd;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.camiloleal.adapters.mysql.PersonEntity;
import org.camiloleal.adapters.mysql.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PersonPersistenceMysqlTest {

    @Autowired
    PersonRepository personRepository;

    @BeforeEach
    void setUp() {
        PersonEntity person = new PersonEntity();
        person.setDni("73207333");
        person.setCity("Cartagena");
        person.setEmail("camiloleal2022@gmail.com");
        person.setFirstName("camilo");
        person.setLastName("Leal");
        person.setAge(35);
        person.setPhone("73207343");
        person.setId(1);
        personRepository.save(person);
    }

    @Test
    void findAll() {
        personRepository.findAll();
        assertFalse(personRepository.findAll().isEmpty());
    }

    @Test
    void getPersonById() {
        assertNotNull(personRepository.getById(1));
    }

    @Test
    void getPersonByEmail() {
        assertNotNull(personRepository.findPersonByEmail("camiloleal06@gmail.com").get());
        assertEquals("Cartagena", personRepository.findPersonByEmail("camiloleal06@gmail.com").get().getCity());
    }

}