package com.example.test.task.service;

import com.example.test.task.model.House;
import com.example.test.task.repository.HouseRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseService {

    private final HouseRepository houseRepository;

    @Autowired
    public HouseService(HouseRepository houseRepository) {
        this.houseRepository = houseRepository;
    }

    @Transactional
    public void save(House house){
        houseRepository.save(house);
    }


    @Transactional
    public void delete(Long id) {
        houseRepository.deleteById(id);
    }


    @Transactional
    public void update(Long id, House house) {
        house.setId(id);
        houseRepository.save(house);
    }


}
