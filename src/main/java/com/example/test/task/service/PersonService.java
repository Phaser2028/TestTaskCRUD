package com.example.test.task.service;

import com.example.test.task.dto.PersonDTO;
import com.example.test.task.model.Person;
import com.example.test.task.repository.PersonRepository;
import com.example.test.task.security.PersonDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;

@Service
public class PersonService implements UserDetailsService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }


    @Transactional
    public void save(Person person) {
        person.setRole("ROLE_RESIDENT");
        personRepository.save(person);
    }


    @Transactional
    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public Person findByName(String name){
        return personRepository.findByName(name).get();
    }

    @Transactional
    public void update(Long id, Person updatedPerson) {

        updatedPerson.setId(id);

        personRepository.save(updatedPerson);
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Optional<Person> u = personRepository.findByName(name);
        if (u.isEmpty()) {
            throw new UsernameNotFoundException(String.format("User %s is not found", name));
        }
        return new org.springframework.security.core.userdetails.User(u.get().getName(), u.get().getPassword(), true, true, true, true, new HashSet<>());
    }

    public String login(String name, String password) {
        Person person = personRepository.findByName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Генерация JWT-токена
        String token = Jwts.builder()
                .setSubject(name)
                .signWith(SignatureAlgorithm.HS256, "your-secret-key")
                .compact();

        return token;
    }
}
