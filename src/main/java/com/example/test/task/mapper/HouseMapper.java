package com.example.test.task.mapper;

import com.example.test.task.dto.HouseDTO;
import com.example.test.task.model.House;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface HouseMapper {
    HouseMapper INSTANCE = Mappers.getMapper(HouseMapper.class);

    HouseDTO houseToHouseDTO(House house);

    House houseDTOToHouse(HouseDTO houseDTO);
}
