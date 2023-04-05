package com.mecorp.mpphw.Api.Model.V1;

import com.mecorp.mpphw.Domain.Car;

import java.util.List;

public class MechanicWithBulkCarsRequestDTO {
    List<Integer> carIds;

    public List<Integer> getCarIds() {
        return carIds;
    }

    public void setCarIds(List<Integer> carIds) {
        this.carIds = carIds;
    }
}
