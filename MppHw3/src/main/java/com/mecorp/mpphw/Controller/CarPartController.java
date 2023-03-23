package com.mecorp.mpphw.Controller;

import com.mecorp.mpphw.Api.Model.V1.*;
import com.mecorp.mpphw.Service.CarPartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-parts")
public class CarPartController {
    private final CarPartService carPartService;

    @Autowired
    public CarPartController(CarPartService carPartService) {
        this.carPartService =  carPartService;
    }

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public List<CarPartEntityDTO> getAllCarParts() {
        return this.carPartService.getCarParts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarPartEntityWithDealershipsDTO getCarPartById(@PathVariable Integer id) {
        return this.carPartService.getCarPartById(id);
    }

    @PostMapping({"/", ""})
    @ResponseStatus(HttpStatus.OK)
    public String createCarPart(@RequestBody CarPartEntityDTO carPartEntityDTO) {
        return this.carPartService.createCarPart(carPartEntityDTO);
    }

    @PutMapping({"/{carPartID}"})
    @ResponseStatus(HttpStatus.OK)
    public String updateCarPart(@PathVariable Integer carPartID, @RequestBody CarPartEntityDTO carPartEntityDTO) {
        return this.carPartService.updateCarPart(carPartID, carPartEntityDTO);
    }

    @DeleteMapping("/{carPartID}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCarPart(@PathVariable Integer carPartID) {
        return this.carPartService.deleteCarPart(carPartID);
    }
}
