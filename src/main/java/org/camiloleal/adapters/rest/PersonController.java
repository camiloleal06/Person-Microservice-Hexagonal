package org.camiloleal.adapters.rest;

import lombok.AllArgsConstructor;
import org.camiloleal.adapters.rest.dto.PersonDto;
import org.camiloleal.adapters.rest.mapper.PersonMapper;
import org.camiloleal.domain.model.Person;
import org.camiloleal.ports.in_port.PersonInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/person")
@AllArgsConstructor
public class PersonController {

    private PersonInterface personInterface;
    private PersonMapper mapper;

    @GetMapping
    public List<Person> findAllPeople() {
        return this.personInterface.findAll();
    }

    @PostMapping
    public Person createPerson(@Valid @RequestBody PersonDto person) {
        return this.personInterface.create(mapper.toPerson(person));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonDto> findPersonById(@PathVariable Integer id) {
        return new ResponseEntity<>(mapper.toPersonDTO(this.personInterface.getPersonById(id)),
                HttpStatus.OK);
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

    @GetMapping(value = "/api", params = "firstName")
    public List<Person> findAllPeopleByFirstName(@RequestParam("firstName") String firstName) {
        return this.personInterface.findAllByContainsFistName(firstName);
    }
}
