package com.mecorp.mpphw.Api.Model.V1;

import com.mecorp.mpphw.Domain.CarPart_CarDealership;

import java.util.List;

public class CarDealershipEntityWithCarPartsDTO {

    private Integer id;
    private String name;
    private String phoneNumber;
    private String email;
    private Integer yearFounded;
    private String address;

    private List<CarPart_CarDealershipDTOForCarDealership> carPartsDTOList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CarPart_CarDealershipDTOForCarDealership> getCarPartsDTOList() {
        return carPartsDTOList;
    }

    public void setCarPartsDTOList(List<CarPart_CarDealershipDTOForCarDealership> carPartsDTOList) {
        this.carPartsDTOList = carPartsDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
