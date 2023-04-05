package com.mecorp.mpphw.Service;

import com.mecorp.mpphw.Api.Mapper.CarDealershipMapper;
import com.mecorp.mpphw.Api.Model.V1.*;
import com.mecorp.mpphw.Domain.*;
import com.mecorp.mpphw.Exceptions.InvalidDataException;
import com.mecorp.mpphw.Exceptions.ResourceNotFoundException;
import com.mecorp.mpphw.Repository.CarDealershipRepository;
import com.mecorp.mpphw.Repository.CarPartRepository;
import com.mecorp.mpphw.Validators.CarDealership.EmailValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class CarDealershipService {

    private final CarDealershipRepository carDealershipRepository;
    private final CarPartRepository carPartRepository;
    private final CarDealershipMapper carDealershipMapper;

    @Autowired
    public CarDealershipService(CarDealershipRepository carDealershipRepository, CarPartRepository carPartRepository, CarDealershipMapper carDealershipMapper) {
        this.carDealershipMapper = carDealershipMapper;
        this.carDealershipRepository = carDealershipRepository;
        this.carPartRepository = carPartRepository;
    }

    public List<CarDealershipEntityDTO> getDealerships() {
        return this.carDealershipRepository.findAll().stream()
                .map(carDealership -> {
                    CarDealershipEntityDTO carDealershipEntityDTO = this.carDealershipMapper.carDealershipToCarDealershipDTO(carDealership);
                    return carDealershipEntityDTO;
                }).collect(Collectors.toList());
    }

    public CarDealershipEntityWithCarPartsDTO getDealershipById(Integer id) {
        Optional<CarDealership> carDealershipOptional = this.carDealershipRepository.findById(id);
        if (carDealershipOptional.isPresent()) {
            CarDealershipEntityWithCarPartsDTO carDealershipEntityWithCarPartsDTO = this.carDealershipMapper.carDealershipToCarDealershipWithCarPartsDTO(carDealershipOptional.get());
            return carDealershipEntityWithCarPartsDTO;
        }
        return null;
    }

    public String createCarDealership(CarDealershipEntityDTO carDealershipEntityDTO) {
        CarDealership carDealership = this.carDealershipMapper.carDealershipDTOToCarDealership(carDealershipEntityDTO);

        if (!EmailValidator.validateEmail(carDealership.getEmail())) {
            throw new InvalidDataException("Email given is not valid");
        }

        this.carDealershipRepository.save(carDealership);
        return "Success";
    }
    public void addCarPart(Integer carDealershipID, CarPart_CarDealershipRequestDTO carPart_carDealershipRequestDTO) {
        Optional<CarPart> carPartOptional = this.carPartRepository.findById(carPart_carDealershipRequestDTO.getCarPartId());
        Optional<CarDealership> carDealershipOptional = this.carDealershipRepository.findById(carDealershipID);

        if (!carPartOptional.isPresent() || !carDealershipOptional.isPresent()) {
            throw new ResourceNotFoundException();
        }

        CarPart carPart = carPartOptional.get();
        CarDealership carDealership = carDealershipOptional.get();

        CarPart_CarDealership carPart_carDealership = new CarPart_CarDealership(carDealership, carPart);
        carPart_carDealership.setCarDealership(carDealership);
        carPart_carDealership.setCarPart(carPart);
        carPart_carDealership.setShippedDate(carPart_carDealershipRequestDTO.getShippedDate());
        carPart_carDealership.setQuantity(carPart_carDealershipRequestDTO.getQuantity());

        carDealership.getCarParts().add(carPart_carDealership);
        this.carDealershipRepository.save(carDealership);

//        Optional<CarPart> carPartOptional = this.carPartRepository.findById(carPart_carDealershipRequestDTO.getCarPartId());
//        Optional<CarDealership> carDealershipOptional = this.carDealershipRepository.findById(carDealershipID);
//
//        if (!carPartOptional.isPresent() || !carDealershipOptional.isPresent()) {
//            throw new ResourceNotFoundException();
//        }
//
//        CarDealership carDealership = carDealershipOptional.get();
//
//        carDealership.addCarPart(carPartOptional.get(), carPart_carDealershipRequestDTO)
//
    }

    public String updateCarDealership(Integer carDealershipID, CarDealershipEntityDTO carDealershipEntityDTO) {
        Optional<CarDealership> carDealershipOptional = this.carDealershipRepository.findById(carDealershipID);
        if (carDealershipOptional.isPresent()) {
            CarDealership carDealershipData = this.carDealershipMapper.carDealershipDTOToCarDealership(carDealershipEntityDTO);
            CarDealership carDealership = carDealershipOptional.get();

            String address = carDealershipData.getAddress();
            String number = carDealershipData.getPhoneNumber();
            String name = carDealershipData.getName();
            String email = carDealershipData.getEmail();
            Integer yearFounded = carDealershipData.getYearFounded();

            if (address != null) {
                carDealership.setAddress(address);
            }

            if (number != null) {
                carDealership.setPhoneNumber(number);
            }

            if (name != null) {
                carDealership.setName(name);
            }

            if (email != null) {
                carDealership.setEmail(email);
            }

            if (yearFounded != null) {
                carDealership.setYearFounded(yearFounded);
            }

            this.carDealershipRepository.save(carDealership);
            return "Success";
        }
        throw new ResourceNotFoundException();
    }

    public String deleteCarDealership(Integer carDealershipID) {
        if (this.carDealershipRepository.existsById(carDealershipID)) {
            this.carDealershipRepository.deleteById(carDealershipID);
            return "Success";
        }
        throw new ResourceNotFoundException();
    }

    public List<CarDealershipNewestPartsReportDTO> computeNewestPartsReport() {
        List<CarDealership> carDealerships = this.carDealershipRepository.findAll();
        List<CarDealershipNewestPartsReportDTO> result = new ArrayList<>();

        for (CarDealership carDealership : carDealerships) {
            List<CarPart_CarDealership> carPart_carDealerships = carDealership.getCarParts();
            int averageYear = (int) carPart_carDealerships.stream()
                    .mapToInt(cpcd -> cpcd.getCarPart().getYearAppeared()).average().orElse(0);
            if (averageYear != 0) {
                CarDealershipNewestPartsReportDTO carDealershipNewestPartsReportDTO = new CarDealershipNewestPartsReportDTO(
                        carDealership.getId(), carDealership.getName(), carDealership.getPhoneNumber(), carDealership.getEmail(),
                        carDealership.getYearFounded(), carDealership.getAddress(), averageYear
                );
                result.add(carDealershipNewestPartsReportDTO);
            }
        }
        result.sort(Comparator.comparingDouble(CarDealershipNewestPartsReportDTO::getPartsAppearYearAverage));
        Collections.reverse(result);

        return result;
    }

    public List<MechanicWithMostCarsDTO> report2(Integer id) {
        Optional<CarDealership> carDealershipOptional = this.carDealershipRepository.findById(id);
        List<MechanicWithMostCarsDTO> result = new ArrayList<>();
        if (carDealershipOptional.isPresent()) {
            List<Car> cars = carDealershipOptional.get().getCars();
            for (Car car : cars) {
                Mechanic mechanic = car.getMechanic();
                Integer numberOfCars = mechanic.getCars().size();
                MechanicWithMostCarsDTO mechanicWithMostCarsDTO = new MechanicWithMostCarsDTO(
                    mechanic.getId(), mechanic.getFirstName(), mechanic.getSecondName(),
                    mechanic.getBrandExpertise(), mechanic.getDateHired(), mechanic.getSalary(), numberOfCars);
                result.add(mechanicWithMostCarsDTO);
            }

            result.sort(Comparator.comparingInt(MechanicWithMostCarsDTO::getNumberOfCars));
            Collections.reverse(result);
            return result;
        }
        return null;
    }
}
