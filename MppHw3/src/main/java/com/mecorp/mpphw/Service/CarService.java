package com.mecorp.mpphw.Service;
import com.mecorp.mpphw.Api.Mapper.CarMapper;
import com.mecorp.mpphw.Api.Mapper.MechanicMapper;
import com.mecorp.mpphw.Api.Model.V1.CarEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarEntityWithMechanicDTO;
import com.mecorp.mpphw.Api.Model.V1.MechanicWithMostCarsDTO;
import com.mecorp.mpphw.Controller.CarController;
import com.mecorp.mpphw.Domain.Car;
import com.mecorp.mpphw.Domain.Mechanic;
import com.mecorp.mpphw.Exceptions.ResourceNotFoundException;
import com.mecorp.mpphw.Repository.CarRepository;
import com.mecorp.mpphw.Repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {
    private final CarMapper carMapper;
    private final CarRepository carRepository;

    private final MechanicMapper mechanicMapper;

    private final MechanicRepository mechanicRepository;

    @Autowired
    public CarService(CarMapper carMapper, MechanicMapper mechanicMapper, CarRepository carRepository, MechanicRepository mechanicRepository) {
        this.carMapper = carMapper;
        this.carRepository = carRepository;
        this.mechanicRepository = mechanicRepository;
        this.mechanicMapper = mechanicMapper;
    }

    public List<CarEntityDTO> getAllCars() {
        return this.carRepository.findAll().stream()
                .map(car -> {
                    CarEntityDTO carEntityDTO = this.carMapper.carToCarDTO(car);
                    return carEntityDTO;
                }).collect(Collectors.toList());
    }

    public CarEntityWithMechanicDTO getCarByID(Integer id) {
        Optional<Car> carOptional = this.carRepository.findById(id);
        return carOptional.map(car -> {
            CarEntityWithMechanicDTO carEntityWithMechanicDTO = this.carMapper.carToCarWithMechanicDTO(car);
            return carEntityWithMechanicDTO;
        }).orElseThrow(ResourceNotFoundException::new);
    }

    public String assignMechanic(Integer carId, Integer mechanicId) {
        Optional<Mechanic> mechanicOptional = this.mechanicRepository.findById(mechanicId);
        Optional<Car> carOptional = this.carRepository.findById(carId);

        if (mechanicOptional.isPresent() && carOptional.isPresent()) {
            Mechanic mechanic = mechanicOptional.get();
            Car car = carOptional.get();
            car.setMechanic(mechanic);
            this.carRepository.save(car);
            return "Success";
        }
        throw new ResourceNotFoundException();
    }

    public String createCar(CarEntityDTO carEntityDTO) {
        Car convertedCar = this.carMapper.carDTOToCar(carEntityDTO);
        Car savedCar = this.carRepository.save(convertedCar);
        return "/cars/" + savedCar.getId();
    }

    public String updateCar(Integer id, CarEntityDTO carEntityDTO) {
        Optional<Car> carOptional = this.carRepository.findById(id);

        if (carOptional.isPresent()) {
            Car carData = this.carMapper.carDTOToCar(carEntityDTO);
            Car car = carOptional.get();

            String brand = carData.getBrand();
            String color = carData.getColor();
            String model = carData.getModel();
            Integer engineCC = carData.getEngineCC();
            Integer engineHP = carData.getEngineHP();

            if (brand != null) {
                car.setBrand(brand);
            }

            if (color != null) {
                car.setColor(color);
            }

            if (model != null) {
                car.setModel(model);
            }

            if (engineCC != null) {
                car.setEngineCC(engineCC);
            }

            if (engineHP != null) {
                car.setEngineHP(engineHP);
            }

            Car savedCar = this.carRepository.save(car);
            return CarController.CAR_CONTROLLER_URL + savedCar.getId();
        }
        throw new ResourceNotFoundException();
    }

    public boolean deleteCar(Integer id) throws ResourceNotFoundException{
        if (this.carRepository.existsById(id)) {
            this.carRepository.deleteById(id);
            return true;
        }
        throw new ResourceNotFoundException();
    }
}
