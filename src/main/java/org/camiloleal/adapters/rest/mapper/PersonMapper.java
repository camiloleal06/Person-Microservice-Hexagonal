package org.camiloleal.adapters.rest.mapper;

import org.camiloleal.adapters.rest.dto.PersonDto;
import org.camiloleal.domain.model.Person;
import org.mapstruct.Mapper;



@Mapper(componentModel = "spring")
public interface PersonMapper {
    PersonDto toPersonDTO (Person person);
    Person toPerson(PersonDto personDto);
}