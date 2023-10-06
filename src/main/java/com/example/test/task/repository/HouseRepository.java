package com.example.test.task.repository;

import com.example.test.task.model.House;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {

}
