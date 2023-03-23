package com.mecorp.mpphw.Service;

import com.mecorp.mpphw.Api.Mapper.CarMapper;
import com.mecorp.mpphw.Api.Mapper.MechanicMapper;
import com.mecorp.mpphw.Api.Model.V1.CarEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.MechanicEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.MechanicEntityWithCarsDTO;
import com.mecorp.mpphw.Api.Model.V1.MechanicWithMostCarsDTO;
import com.mecorp.mpphw.Controller.MechanicController;
import com.mecorp.mpphw.Domain.Car;
import com.mecorp.mpphw.Domain.Mechanic;
import com.mecorp.mpphw.Exceptions.ResourceNotFoundException;
import com.mecorp.mpphw.Repository.MechanicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class MechanicService {

    private final MechanicMapper mechanicMapper;
    private final CarMapper carMapper;

    private final MechanicRepository mechanicRepository;

    @Autowired
    public MechanicService(MechanicMapper mechanicMapper, CarMapper carMapper, MechanicRepository mechanicRepository) {
        this.mechanicMapper = mechanicMapper;
        this.mechanicRepository = mechanicRepository;
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
        return null;
    }

    public String createMechanic(MechanicEntityDTO mechanicEntityDTO) {
        Mechanic savedMechanic = this.mechanicRepository.save(this.mechanicMapper.mechanicDTOToMechanic(mechanicEntityDTO));
        return MechanicController.MECHANIC_CONTROLLER_URL + savedMechanic.getId().toString();
    }

    public String updateMechanic(Integer id, MechanicEntityDTO mechanicEntityDTO) {
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
            return MechanicController.MECHANIC_CONTROLLER_URL + "/" + savedMechanic.getId().toString();
        }
        throw new ResourceNotFoundException();
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
