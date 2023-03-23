package com.mecorp.mpphw.Api.Mapper;


import com.mecorp.mpphw.Api.Model.V1.CarEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarEntityWithMechanicDTO;
import com.mecorp.mpphw.Api.Model.V1.CarEntityWithMechanicIdDTO;
import com.mecorp.mpphw.Domain.Car;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarMapper {
    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);
    CarEntityDTO carToCarDTO(Car car);

    @Mapping(target = "mechanicId", source = "mechanic.id")
    CarEntityWithMechanicIdDTO carToCarWithMechanicIdDTO(Car car);

    @Mapping(target = "mechanicEntityDTO", source = "mechanic")
    CarEntityWithMechanicDTO carToCarWithMechanicDTO(Car car);
    Car carDTOToCar(CarEntityDTO carEntityDTO);

    Car carWithMechanicIdDTOToCar(CarEntityWithMechanicIdDTO carEntityWithMechanicIdDTO);

    Car carWithMechanicDTOToCar(CarEntityWithMechanicDTO carEntityWithMechanicDTO);
}
