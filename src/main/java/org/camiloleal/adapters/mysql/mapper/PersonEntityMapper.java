package org.camiloleal.adapters.mysql.mapper;

import java.util.List;

import org.camiloleal.adapters.mysql.PersonEntity;
import org.camiloleal.domain.model.Person;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonEntityMapper {

    Person toPerson(PersonEntity personEntity);

    PersonEntity toEntity(Person person);

    List<Person> toListPerson(List<PersonEntity> person);

}