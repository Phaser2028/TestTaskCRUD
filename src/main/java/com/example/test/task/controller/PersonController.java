package com.example.test.task.controller;

import com.example.test.task.dto.PersonDTO;
import com.example.test.task.mapper.PersonMapper;
import com.example.test.task.model.Person;
import com.example.test.task.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonMapper personMapper;

    private final PersonService personService;


    @Autowired
    public PersonController(PersonMapper personMapper, PersonService personService) {
        this.personMapper = personMapper;
        this.personService = personService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody PersonDTO personDTO) {
        String token = personService.login(personDTO.getName(), personDTO.getPassword());
        return ResponseEntity.ok(token);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addPerson(@RequestBody PersonDTO personDTO) {
        personService.save(PersonMapper.INSTANCE.personDTOToPerson(personDTO));
        return ResponseEntity.ok(personDTO);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_RESIDENT','ROLE_OWNER')")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        personService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAnyAuthority('ROLE_RESIDENT','ROLE_OWNER')")
    public ResponseEntity<?> updatePerson(@PathVariable Long id, @RequestBody PersonDTO updatedPersonDTO) {

        personService.update(id,personMapper.personDTOToPerson(updatedPersonDTO));
        return ResponseEntity.ok(updatedPersonDTO);
    }





}
