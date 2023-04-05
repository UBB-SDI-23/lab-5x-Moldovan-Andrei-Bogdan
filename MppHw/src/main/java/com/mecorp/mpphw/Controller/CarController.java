package com.mecorp.mpphw.Controller;

import com.mecorp.mpphw.Api.Model.V1.CarEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarEntityWithMechanicDTO;
import com.mecorp.mpphw.Api.Model.V1.CarEntityWithMechanicIdDTO;
import com.mecorp.mpphw.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CarController.CAR_CONTROLLER_URL)
public class CarController {
    private final CarService carService;

    public final static String CAR_CONTROLLER_URL = "/cars";

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public List<CarEntityDTO> getAllCars() {
        return this.carService.getAllCars();
    }

    @PostMapping({"", "/"})
    @ResponseStatus(HttpStatus.CREATED)
    public String createCar(@RequestBody CarEntityDTO carEntityDTO) {
        return this.carService.createCar(carEntityDTO);
    }

    @PostMapping("/{carId}/mechanic")
    @ResponseStatus(HttpStatus.OK)
    public String assignCarToMechanic(@PathVariable Integer carId, @RequestBody Integer mechanicID) {
        return this.carService.assignMechanic(carId, mechanicID);
    }

    @GetMapping("/{id}")
    public CarEntityWithMechanicDTO getCarByID(@PathVariable Integer id) {
//        CarEntityWithMechanicDTO responseCarEntityDTO = this.carService.getCarByID(id);
//
//        if (responseCarEntityDTO != null) {
//            return new ResponseEntity<>(
//                    responseCarEntityDTO, HttpStatus.OK
//            );
//        }
//
//        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        return this.carService.getCarByID(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public String updateCar(@PathVariable Integer id, @RequestBody CarEntityDTO carEntityDTO) {
        return this.carService.updateCar(id, carEntityDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteCar(@PathVariable Integer id) {
        return this.carService.deleteCar(id);
    }
}
