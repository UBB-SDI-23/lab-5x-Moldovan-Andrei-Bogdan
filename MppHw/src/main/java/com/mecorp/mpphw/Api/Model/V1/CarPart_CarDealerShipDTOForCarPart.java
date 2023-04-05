package com.mecorp.mpphw.Api.Model.V1;

public class CarPart_CarDealerShipDTOForCarPart {
    private CarDealershipEntityDTO carDealership;
    private String shippedDate;
    private Integer quantity;

    public CarDealershipEntityDTO getCarDealership() {
        return carDealership;
    }

    public void setCarDealership(CarDealershipEntityDTO carDealership) {
        this.carDealership = carDealership;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
