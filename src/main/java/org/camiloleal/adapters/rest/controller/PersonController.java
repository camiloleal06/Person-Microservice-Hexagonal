package org.camiloleal.adapters.rest.controller;

import lombok.AllArgsConstructor;

import org.camiloleal.ports.in_port.PersonInterface;
import org.camiloleal.domain.model.Person;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonInterface personInterface;

    @GetMapping
    public List<Person> findAllPeople() {
        return this.personInterface.findAll();
    }

    @PostMapping
    public Person createPerson(@RequestBody Person person) {
        return this.personInterface.create(person);
    }

    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Integer id) {
        return this.personInterface.getPersonById(id);
    }

    @GetMapping("/email/{email}")
    public Person findPersonById(@PathVariable String email) {
        return this.personInterface.getPersonByEmail(email);
    }
}

