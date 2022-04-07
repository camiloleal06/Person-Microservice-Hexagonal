package org.camiloleal.adapters.mysql;

import java.util.Optional;

import org.camiloleal.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    Optional<Person> findPersonByEmail(String email);
}
