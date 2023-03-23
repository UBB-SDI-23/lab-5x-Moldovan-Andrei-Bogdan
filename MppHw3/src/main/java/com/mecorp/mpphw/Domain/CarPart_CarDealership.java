package com.mecorp.mpphw.Domain;

import com.mecorp.mpphw.CompositeKeys.CarPartCarDealershipKey;
import jakarta.persistence.*;

@Entity
public class CarPart_CarDealership {

    @EmbeddedId
    private CarPartCarDealershipKey id;

    @ManyToOne
    @MapsId("carPartID")
    private CarPart carPart;

    @ManyToOne
    @MapsId("carDealershipID")
    private CarDealership carDealership;

    @Column(name = "SHIP_DATE")
    private String shippedDate;

    @Column(name = "QUANTITY")
    private Integer quantity;

    public CarPart_CarDealership() {

    }

    public CarPart_CarDealership(CarDealership carDealership, CarPart carPart) {
        this.carDealership = carDealership;
        this.carPart = carPart;
        this.id = new CarPartCarDealershipKey(carDealership.getId(), carPart.getId());
    }

    public CarPartCarDealershipKey getId() {
        return id;
    }

    public void setId(CarPartCarDealershipKey id) {
        this.id = id;
    }

    public CarPart getCarPart() {
        return carPart;
    }

    public void setCarPart(CarPart carPart) {
        this.carPart = carPart;
    }

    public CarDealership getCarDealership() {
        return carDealership;
    }

    public void setCarDealership(CarDealership carDealership) {
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
