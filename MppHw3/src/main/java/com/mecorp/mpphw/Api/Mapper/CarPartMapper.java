package com.mecorp.mpphw.Api.Mapper;

import com.mecorp.mpphw.Api.Model.V1.CarDealershipEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarDealershipEntityWithCarPartsDTO;
import com.mecorp.mpphw.Api.Model.V1.CarPartEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.CarPartEntityWithDealershipsDTO;
import com.mecorp.mpphw.Domain.CarDealership;
import com.mecorp.mpphw.Domain.CarPart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CarPartMapper {
    CarPartMapper INSTANCE = Mappers.getMapper(CarPartMapper.class);

    CarPartEntityDTO carPartToCarPartDTO(CarPart carPart);



    @Mapping(target = "carDealershipsDTOList", source = "carDealerships")
    CarPartEntityWithDealershipsDTO carPartToCarPartWithDealershipsDTO(CarPart carPart);

    CarPart carPartDTOToCarPart(CarPartEntityDTO carPartEntityDTO);

    CarPart carPartWithDealershipsDTOToCarPart(CarPartEntityWithDealershipsDTO carPartEntityWithDealershipsDTO);
}
