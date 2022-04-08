package org.camiloleal.adapters.rest.controller;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.camiloleal.adapters.rest.PersonController;
import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.in_port.PersonInterface;
import org.junit.jupiter.api.Test;

class PersonControllerTest {

    PersonInterface service = mock(PersonInterface.class);
    PersonController sut = new PersonController(service);

    Person personDomain = Person.builder().id(1).dni("73207639").city("Cartagena").email("camiloleal@gmail.com")
            .firstName("camilo").lastName("Leal").age(35).phone("73207639").build();

    @Test
    void shouldGetAllPeople() {
        sut.findAllPeople();
        verify(service).findAll();
    }

    @Test
    void shouldCallSavePerson() {
        sut.createPerson(personDomain);
        verify(service).create(personDomain);
    }

    @Test
    void shouldCallGetPersonById() {
        sut.findPersonById(1);
        verify(service).getPersonById(1);
    }

    @Test
    void shouldCallGetPersonByEmail() {
        final String EMAIL = "camilo.leal@pragma.com.co";
        sut.findPersonById(EMAIL);
        verify(service).getPersonByEmail(EMAIL);
    }

}
