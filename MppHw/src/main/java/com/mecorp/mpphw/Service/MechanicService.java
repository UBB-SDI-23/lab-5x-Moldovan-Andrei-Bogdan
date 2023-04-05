package com.mecorp.mpphw.Service;

import com.mecorp.mpphw.Api.Mapper.CarMapper;
import com.mecorp.mpphw.Api.Mapper.MechanicMapper;
import com.mecorp.mpphw.Api.Model.V1.*;
import com.mecorp.mpphw.Controller.MechanicController;
import com.mecorp.mpphw.Domain.Car;
import com.mecorp.mpphw.Domain.Mechanic;
import com.mecorp.mpphw.Exceptions.InvalidDataException;
import com.mecorp.mpphw.Exceptions.ResourceNotFoundException;
import com.mecorp.mpphw.Repository.CarRepository;
import com.mecorp.mpphw.Repository.MechanicRepository;
import com.mecorp.mpphw.Validators.Mechanic.NameValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MechanicService {

    private final MechanicMapper mechanicMapper;
    private final CarMapper carMapper;

    private final MechanicRepository mechanicRepository;

    private final CarRepository carRepository;

    @Autowired
    public MechanicService(MechanicMapper mechanicMapper, CarMapper carMapper, MechanicRepository mechanicRepository, CarRepository carRepository) {
        this.mechanicMapper = mechanicMapper;
        this.mechanicRepository = mechanicRepository;
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }

    public List<MechanicEntityDTO> getAllMechanics() {
        return this.mechanicRepository.findAll().stream()
                .map(mechanic -> {
                    MechanicEntityDTO mechanicEntityDTO = this.mechanicMapper.mechanicToMechanicDTO(mechanic);
                    return mechanicEntityDTO;
                }).collect(Collectors.toList());
    }

    public MechanicEntityWithCarsDTO getMechanicByID(Integer id) {
        Optional<Mechanic> mechanicOptional = this.mechanicRepository.findById(id);
        if (mechanicOptional.isPresent()) {
            Mechanic mechanic = mechanicOptional.get();
            return this.mechanicMapper.mechanicToMechanicWithCarsDTO(mechanic);
        }
        throw new ResourceNotFoundException("Mechanic with id given was not found");
    }

    public void createMechanic(MechanicEntityDTO mechanicEntityDTO) {
        Mechanic convertedMechanic = this.mechanicMapper.mechanicDTOToMechanic(mechanicEntityDTO);

        if (!NameValidator.validateName(convertedMechanic.getFirstName())) {
            throw new InvalidDataException("Fist name is not valid");
        }

        if (!NameValidator.validateName(convertedMechanic.getSecondName())) {
            throw  new InvalidDataException("Second name is not valid");
        }

        Mechanic savedMechanic = this.mechanicRepository.save(convertedMechanic);
    }

    public void updateMechanic(Integer id, MechanicEntityDTO mechanicEntityDTO) {
        Optional<Mechanic> mechanicOptional = this.mechanicRepository.findById(id);
        if (mechanicOptional.isPresent()) {
            Mechanic mechanicData = this.mechanicMapper.mechanicDTOToMechanic(mechanicEntityDTO);
            Mechanic mechanic = mechanicOptional.get();

            String firstName = mechanicData.getFirstName();
            String secondName = mechanicData.getSecondName();
            String brandExpertise = mechanicData.getBrandExpertise();
            String dateHired = mechanicData.getDateHired();
            Integer salary = mechanicData.getSalary();

            if (firstName != null) {
                mechanic.setFirstName(firstName);
            }

            if (secondName != null) {
                mechanic.setSecondName(secondName);
            }

            if (brandExpertise != null) {
                mechanic.setBrandExpertise(brandExpertise);
            }

            if (dateHired != null) {
                mechanic.setDateHired(dateHired);
            }

            if (salary != null) {
                mechanic.setSalary(salary);
            }

            Mechanic savedMechanic = this.mechanicRepository.save(mechanic);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    public boolean deleteMechanic(Integer id) throws ResourceNotFoundException {
        if (this.mechanicRepository.existsById(id)) {
            this.mechanicRepository.deleteById(id);
            return true;
        }
        throw new ResourceNotFoundException();
    }

    public List<MechanicEntityDTO> getFilteredMechanics(Integer value) {
        return this.mechanicRepository.findAll().stream()
                .filter(mechanic -> mechanic.getSalary() > value)
                .map(mechanic -> {
                    MechanicEntityDTO mechanicEntityDTO = this.mechanicMapper.mechanicToMechanicDTO(mechanic);
                    return mechanicEntityDTO;
                }).collect(Collectors.toList());
    }

    public void associateCars(Integer mechanicID, MechanicWithBulkCarsRequestDTO mechanicWithBulkCarsRequestDTO) {
        Optional<Mechanic> mechanicOptional = this.mechanicRepository.findById(mechanicID);
        if (!mechanicOptional.isPresent()) {
            throw new InvalidDataException("No mechanic with that ID exists");
        } else {
            Mechanic mechanic = mechanicOptional.get();
            for (Integer carID : mechanicWithBulkCarsRequestDTO.getCarIds()) {
                Optional<Car> carOptional = this.carRepository.findById(carID);
                if (!carOptional.isPresent()) {
                    throw new InvalidDataException("One of the cars given does not exist");
                } else {
                    Car car = carOptional.get();
                    car.setMechanic(mechanic);
                    this.carRepository.save(car);
                }
            }
        }
    }

//    public List<MechanicWithMostCarsDTO> getMechanicsSortedByNumberOfCars() {
//        List<Mechanic> mechanics = this.mechanicRepository.findAll();
//        List<MechanicWithMostCarsDTO> result = new ArrayList<>();
//
//        for (Mechanic mechanic : mechanics) {
//            Integer numberOfCars = mechanic.getCars().size();
//
//            MechanicWithMostCarsDTO mechanicWithMostCarsDTO = new MechanicWithMostCarsDTO(
//                    mechanic.getId(), mechanic.getFirstName(), mechanic.getSecondName(),
//                    mechanic.getBrandExpertise(), mechanic.getDateHired(), mechanic.getSalary(), numberOfCars);
//
//            result.add(mechanicWithMostCarsDTO);
//        }
//
//        result.sort(Comparator.comparingInt(MechanicWithMostCarsDTO::getNumberOfCars));
//        Collections.reverse(result);
//        return result;
//    }
}
