package com.example.test.task.mapper.impl;

import com.example.test.task.dto.HouseDTO;
import com.example.test.task.mapper.HouseMapper;
import com.example.test.task.model.House;
import org.springframework.stereotype.Component;

@Component
public class HouseMapperImpl implements HouseMapper {
    @Override
    public HouseDTO houseToHouseDTO(House house) {
        return HouseMapper.INSTANCE.houseToHouseDTO(house);
    }

    @Override
    public House houseDTOToHouse(HouseDTO houseDTO) {
        return HouseMapper.INSTANCE.houseDTOToHouse(houseDTO);
    }
}
