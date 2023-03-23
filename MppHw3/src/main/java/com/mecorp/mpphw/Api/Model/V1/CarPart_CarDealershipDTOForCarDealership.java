package com.mecorp.mpphw.Api.Model.V1;

public class CarPart_CarDealershipDTOForCarDealership {
    private CarPartEntityDTO carPart;
    private String shippedDate;
    private Integer quantity;

    public CarPartEntityDTO getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPartEntityDTO carPart) {
        this.carPart = carPart;
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
