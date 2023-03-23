package com.mecorp.mpphw.Api.Mapper;

import com.mecorp.mpphw.Api.Model.V1.*;
import com.mecorp.mpphw.Domain.CarDealership;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarDealershipMapper {
    CarDealershipMapper INSTANCE = Mappers.getMapper(CarDealershipMapper.class);

    CarDealershipEntityDTO carDealershipToCarDealershipDTO(CarDealership carDealership);


    @Mapping(target = "carPartsDTOList", source = "carParts")
    CarDealershipEntityWithCarPartsDTO carDealershipToCarDealershipWithCarPartsDTO(CarDealership carDealership);

    CarDealership carDealershipDTOToCarDealership(CarDealershipEntityDTO carDealershipEntityDTO);

    CarDealership carDealershipWithCarPartsDTOToCarDealership(CarDealershipEntityWithCarPartsDTO carDealershipEntityWithCarPartsDTO);
}
