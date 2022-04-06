package org.camiloleal.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.out_port.PersonPersistence;
import org.junit.jupiter.api.Test;

class PersonServiceImplTest {

    private final PersonPersistence personService = mock(PersonPersistence.class);

    PersonServiceImpl sut = new PersonServiceImpl(personService);

    final int ID = 1;

    final String EMAIL = "camiloleal@gmail.com";

    Person personDomain = Person.builder().id(1).dni("73207639").city("Cartagena").email("camiloleal@gmail.com")
            .firstName("camilo").lastName("Leal").age(35).phone("73207639").build();
    List<Person> listPerson = List.of(personDomain);

    @Test
    void shouldCallServiceCreate() {
        when(personService.create(personDomain)).thenReturn(personDomain);
        assertNotNull(sut.create(personDomain));
        verify(personService, times(1)).create(personDomain);
    }

    @Test
    void shouldCallServiceFindAll() {
        when(personService.findAll()).thenReturn(listPerson);
        assertFalse(sut.findAll().isEmpty());
        assertEquals(1, sut.findAll().size());
        verify(personService, times(2)).findAll();
    }

    @Test
    void shouldCallServiceGetPersonById() {
        when(personService.getPersonById(ID)).thenReturn(personDomain);
        assertNotEquals(null, sut.getPersonById(ID));
        assertEquals("73207639", sut.getPersonById(ID).getDni());
        assertEquals("Cartagena", sut.getPersonById(ID).getCity());
        verify(personService, times(3)).getPersonById(ID);
    }

    @Test
    void shouldCallServiceGetPersonByEmail() {
        when(personService.getPersonByEmail(EMAIL)).thenReturn(personDomain);
        assertNotEquals(null, sut.getPersonByEmail(EMAIL));
        assertEquals("73207639", sut.getPersonByEmail(EMAIL).getDni());
        verify(personService, times(2)).getPersonByEmail(EMAIL);
    }

}