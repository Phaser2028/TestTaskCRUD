package com.example.test.task.repository;

import com.example.test.task.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person,Long> {
    void deleteById(Long id);
    Optional<Person> findByName(String name);
}
