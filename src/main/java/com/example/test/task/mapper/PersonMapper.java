package com.example.test.task.mapper;


import com.example.test.task.dto.PersonDTO;
import com.example.test.task.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    PersonDTO personToPersonDTO(Person person);

    Person personDTOToPerson(PersonDTO personDTO);
}
