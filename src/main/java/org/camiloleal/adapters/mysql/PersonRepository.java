package org.camiloleal.adapters.mysql;

import org.camiloleal.domain.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
    Person findByEmail(String email);
}
