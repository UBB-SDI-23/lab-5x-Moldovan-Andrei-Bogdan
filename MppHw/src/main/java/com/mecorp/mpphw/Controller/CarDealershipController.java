package com.mecorp.mpphw.Controller;

import com.mecorp.mpphw.Api.Model.V1.*;
import com.mecorp.mpphw.Service.CarDealershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car-dealerships")
public class CarDealershipController {

    private final CarDealershipService carDealershipService;

    @Autowired
    public CarDealershipController(CarDealershipService carDealershipService) {
        this.carDealershipService = carDealershipService;
    }

    @GetMapping({"", "/"})
    @ResponseStatus(HttpStatus.OK)
    public List<CarDealershipEntityDTO> getAllCarDealerships() {
        return this.carDealershipService.getDealerships();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDealershipEntityWithCarPartsDTO getCarDealerShipById(@PathVariable Integer id) {
        return this.carDealershipService.getDealershipById(id);
    }

    @GetMapping("/average-parts-appeared-year")
    @ResponseStatus(HttpStatus.OK)
    public List<CarDealershipNewestPartsReportDTO> getDealershipsSortedByNewestParts() {
        return this.carDealershipService.computeNewestPartsReport();
    }

    @GetMapping("/{carDealershipId}/report2")
    @ResponseStatus(HttpStatus.OK)
    public List<MechanicWithMostCarsDTO> getReport2(@PathVariable Integer carDealershipId) {
        return this.carDealershipService.report2(carDealershipId);
    }

    @PostMapping({"/", ""})
    @ResponseStatus(HttpStatus.OK)
    public String createCarDealership(@RequestBody CarDealershipEntityDTO carDealershipEntityDTO) {
        return this.carDealershipService.createCarDealership(carDealershipEntityDTO);
    }

    @PostMapping({"/{dealershipID}/car-part", "/{dealershipID}/car-part/"})
    @ResponseStatus(HttpStatus.OK)
    public void addCarPart(@PathVariable Integer dealershipID, @RequestBody CarPart_CarDealershipRequestDTO requestDTO) {
        this.carDealershipService.addCarPart(dealershipID, requestDTO);
    }

    @PutMapping({"/{dealershipID}"})
    @ResponseStatus(HttpStatus.OK)
    public String updateCarDealership(@PathVariable Integer dealershipID, @RequestBody CarDealershipEntityDTO carDealershipEntityDTO) {
        return this.carDealershipService.updateCarDealership(dealershipID, carDealershipEntityDTO);
    }

    @DeleteMapping("/{dealershipID}")
    @ResponseStatus(HttpStatus.OK)
    public String deleteCarDealership(@PathVariable Integer dealershipID) {
        return this.carDealershipService.deleteCarDealership(dealershipID);
    }
}
