package com.mecorp.mpphw.Api.Model.V1;

import com.mecorp.mpphw.Domain.CarDealership;
import com.mecorp.mpphw.Domain.CarPart_CarDealership;

import java.util.List;

public class CarPartEntityWithDealershipsDTO {

    private Integer id;
    private String name;
    private Integer yearAppeared;

    private List<CarPart_CarDealerShipDTOForCarPart> carDealershipsDTOList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearAppeared() {
        return yearAppeared;
    }

    public void setYearAppeared(Integer yearAppeared) {
        this.yearAppeared = yearAppeared;
    }

    public List<CarPart_CarDealerShipDTOForCarPart> getCarDealershipsDTOList() {
        return carDealershipsDTOList;
    }

    public void setCarDealershipsDTOList(List<CarPart_CarDealerShipDTOForCarPart> carDealershipsDTOList) {
        this.carDealershipsDTOList = carDealershipsDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
