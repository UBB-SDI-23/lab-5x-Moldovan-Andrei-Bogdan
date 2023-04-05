package com.mecorp.mpphw.Service;

import com.mecorp.mpphw.Api.Mapper.CarPartMapper;
import com.mecorp.mpphw.Api.Model.V1.CarDealershipEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarPartEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarPartEntityWithDealershipsDTO;
import com.mecorp.mpphw.Domain.CarDealership;
import com.mecorp.mpphw.Domain.CarPart;
import com.mecorp.mpphw.Exceptions.ResourceNotFoundException;
import com.mecorp.mpphw.Repository.CarPartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarPartService {

    private final CarPartRepository carPartRepository;

    private final CarPartMapper carPartMapper;

    @Autowired
    public CarPartService(CarPartRepository carPartRepository, CarPartMapper carPartMapper) {
        this.carPartMapper = carPartMapper;
        this.carPartRepository = carPartRepository;
    }

    public List<CarPartEntityDTO> getCarParts() {
        return this.carPartRepository.findAll().stream()
                .map(carPart -> {
                    CarPartEntityDTO carPartEntityDTO = this.carPartMapper.carPartToCarPartDTO(carPart);
                    return carPartEntityDTO;
                }).collect(Collectors.toList());
    }

    public CarPartEntityWithDealershipsDTO getCarPartById(Integer id) {
        Optional<CarPart> carPartOptional = this.carPartRepository.findById(id);
        if (carPartOptional.isPresent()) {
            CarPartEntityWithDealershipsDTO carPartEntityWithDealershipsDTO = this.carPartMapper.carPartToCarPartWithDealershipsDTO(carPartOptional.get());
            return carPartEntityWithDealershipsDTO;
        }
        return null;
    }

    public String createCarPart(CarPartEntityDTO carPartEntityDTO) {
        CarPart carPart = this.carPartMapper.carPartDTOToCarPart(carPartEntityDTO);
        this.carPartRepository.save(carPart);
        return "Success";
    }

    public String updateCarPart(Integer carPartID, CarPartEntityDTO carPartEntityDTO) {
        Optional<CarPart> carPartOptional = this.carPartRepository.findById(carPartID);
        if (carPartOptional.isPresent()) {
            CarPart carPartData = this.carPartMapper.carPartDTOToCarPart(carPartEntityDTO);
            CarPart carPart = carPartOptional.get();

            String name = carPartData.getName();
            Integer yearAppeared = carPartData.getYearAppeared();

            if (name != null) {
                carPart.setName(name);
            }

            if (yearAppeared != null) {
                carPart.setYearAppeared(yearAppeared);
            }

            this.carPartRepository.save(carPart);
            return "Success";
        }
        throw new ResourceNotFoundException();
    }

    public String deleteCarPart(Integer carPartID) {
        if (this.carPartRepository.existsById(carPartID)) {
            this.carPartRepository.deleteById(carPartID);
            return "Success";
        }
        throw new ResourceNotFoundException();
    }
}
