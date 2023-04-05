package com.mecorp.mpphw.Controller;

import com.mecorp.mpphw.Api.Model.V1.*;
import com.mecorp.mpphw.Service.MechanicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(MechanicController.MECHANIC_CONTROLLER_URL)
public class MechanicController {
    public final static String MECHANIC_CONTROLLER_URL = "/mechanics";

    private final MechanicService mechanicService;

    @Autowired
    public MechanicController(MechanicService mechanicService) {
        this.mechanicService = mechanicService;
    }

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public List<MechanicEntityDTO> getAllMechanics() {
        return this.mechanicService.getAllMechanics();
    }

    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public MechanicEntityWithCarsDTO getMechanicByID(@PathVariable Integer id) {
        return this.mechanicService.getMechanicByID(id);
    }

//    @GetMapping("/cars-sorted")
//    @ResponseStatus(HttpStatus.OK)
//    public List<MechanicWithMostCarsDTO> getMechanicsSortedByCars() {
//        return this.mechanicService.getMechanicsSortedByNumberOfCars();
//    }

    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public void createMechanic(@RequestBody MechanicEntityDTO mechanicEntityDTO) {
        this.mechanicService.createMechanic(mechanicEntityDTO);
    }

    @PostMapping("/{mechanicID}/cars")
    @ResponseStatus(HttpStatus.OK)
    public void addCarsToMechanic(@PathVariable Integer mechanicID, @RequestBody MechanicWithBulkCarsRequestDTO mechanicWithBulkCarsRequestDTO) {
        this.mechanicService.associateCars(mechanicID, mechanicWithBulkCarsRequestDTO);
    }

    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void updateMechanic(@PathVariable Integer id, @RequestBody MechanicEntityDTO mechanicEntityDTO) {
        this.mechanicService.updateMechanic(id, mechanicEntityDTO);
    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteMechanic(@PathVariable Integer id) {
        return this.mechanicService.deleteMechanic(id);
    }

    @GetMapping({"/filter/{value}"})
    @ResponseStatus(HttpStatus.OK)
    public List<MechanicEntityDTO> getFilteredMechanics(@PathVariable Integer value) {
        return this.mechanicService.getFilteredMechanics(value);
    }
 }
