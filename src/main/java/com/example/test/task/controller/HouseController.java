package com.example.test.task.controller;


import com.example.test.task.dto.HouseDTO;
import com.example.test.task.dto.PersonDTO;
import com.example.test.task.mapper.HouseMapper;
import com.example.test.task.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/house")
public class HouseController {
    private final HouseMapper houseMapper;
    private final HouseService houseService;

    @Autowired
    public HouseController(HouseMapper houseMapper, HouseService houseService) {
        this.houseMapper = houseMapper;
        this.houseService = houseService;
    }

    @PostMapping("/add")
    @PreAuthorize("hasAuthority('ROLE_OWNER')")
    public ResponseEntity<?> addHouse(@RequestBody HouseDTO houseDTO) {
        houseService.save(HouseMapper.INSTANCE.houseDTOToHouse(houseDTO));
        return ResponseEntity.ok(houseDTO);
    }

    @PostMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_OWNER')")
    public ResponseEntity<?> deleteHouse(@PathVariable Long id) {
        houseService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PostMapping("/update/{id}")
    @PreAuthorize("hasAuthority('ROLE_OWNER')")
    public ResponseEntity<?> updateHouse(@PathVariable Long id, @RequestBody HouseDTO updatedHouseDTO) {

        houseService.update(id,houseMapper.houseDTOToHouse(updatedHouseDTO));

        return ResponseEntity.ok(updatedHouseDTO);
    }
}

