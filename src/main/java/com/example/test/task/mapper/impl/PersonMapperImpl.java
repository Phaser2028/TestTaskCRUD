package com.example.test.task.mapper.impl;


import com.example.test.task.dto.PersonDTO;
import com.example.test.task.mapper.PersonMapper;
import com.example.test.task.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonMapperImpl implements PersonMapper {

    @Override
    public PersonDTO personToPersonDTO(Person person) {
        return PersonMapper.INSTANCE.personToPersonDTO(person);
    }

    @Override
    public Person personDTOToPerson(PersonDTO personDTO) {
        return PersonMapper.INSTANCE.personDTOToPerson(personDTO);
    }

}
