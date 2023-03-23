package com.mecorp.mpphw.Api.Mapper;

import com.mecorp.mpphw.Api.Model.V1.MechanicEntityDTO;
import com.mecorp.mpphw.Api.Model.V1.MechanicEntityWithCarsDTO;
import com.mecorp.mpphw.Domain.Mechanic;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MechanicMapper {
    MechanicMapper INSTANCE = Mappers.getMapper(MechanicMapper.class);
    MechanicEntityDTO mechanicToMechanicDTO(Mechanic mechanic);
    @Mapping(target = "carEntityDTOList", source = "cars")
    MechanicEntityWithCarsDTO mechanicToMechanicWithCarsDTO(Mechanic mechanic);
    Mechanic mechanicDTOToMechanic(MechanicEntityDTO mechanicEntityDTO);

    Mechanic mechanicWithCarsDTOToMechanic(MechanicEntityWithCarsDTO mechanicEntityWithCarsDTO);
}
