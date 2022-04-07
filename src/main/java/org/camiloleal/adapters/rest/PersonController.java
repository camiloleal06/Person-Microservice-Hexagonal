package org.camiloleal.adapters.rest;

import java.util.List;

import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.in_port.PersonInterface;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

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

    @DeleteMapping("/{id}")
    public void deletePersonById(@PathVariable Integer id) {
        personInterface.deletePersonById(id);
    }

    @PutMapping("/{id}")
    public Person updatePersonById(@PathVariable Integer id, @RequestBody Person person) {
        return this.personInterface.updatePersonById(id, person);
    }
}
