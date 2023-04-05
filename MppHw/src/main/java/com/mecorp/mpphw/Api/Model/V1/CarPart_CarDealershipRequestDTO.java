package com.mecorp.mpphw.Api.Model.V1;

public class CarPart_CarDealershipRequestDTO {

    private Integer carPartId;

    private String shippedDate;

    private Integer quantity;

    public Integer getCarPartId() {
        return carPartId;
    }

    public void setCarPartId(Integer carPartId) {
        this.carPartId = carPartId;
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
