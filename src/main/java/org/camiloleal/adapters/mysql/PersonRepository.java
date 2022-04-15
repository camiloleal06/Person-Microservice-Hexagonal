package org.camiloleal.adapters.mysql;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {

    Optional<PersonEntity> findPersonByEmail(String email);

    Optional<PersonEntity> findPersonByDni(String dni);

    List<PersonEntity> findByFirstNameContains(String firstName);

}
