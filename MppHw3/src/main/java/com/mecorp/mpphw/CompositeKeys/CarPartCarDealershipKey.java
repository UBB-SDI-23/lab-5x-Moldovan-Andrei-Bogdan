package com.mecorp.mpphw.CompositeKeys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CarPartCarDealershipKey implements Serializable {

    @Column(name = "CARPART_ID")
    private Integer carPartID;

    @Column(name = "CARDEALERSHIP_ID")
    private Integer carDealershipID;

    public CarPartCarDealershipKey() {

    }

    public CarPartCarDealershipKey(Integer carDealershipID, Integer carPartID) {
        this.carPartID = carPartID;
        this.carDealershipID = carDealershipID;
    }

    public Integer getCarPartID() {
        return carPartID;
    }

    public void setCarPartID(Integer carPartID) {
        this.carPartID = carPartID;
    }

    public Integer getCarDealershipID() {
        return carDealershipID;
    }

    public void setCarDealershipID(Integer carDealershipID) {
        this.carDealershipID = carDealershipID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPartCarDealershipKey that = (CarPartCarDealershipKey) o;
        return carPartID.equals(that.carPartID) && carDealershipID.equals(that.carDealershipID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carPartID, carDealershipID);
    }
}
