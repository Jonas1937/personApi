package com.jonas.peopleapi.mapper;

import com.jonas.peopleapi.dto.PersonDTO;
import com.jonas.peopleapi.entity.Person;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO dto);

    PersonDTO toDTO(Person dto);
}
