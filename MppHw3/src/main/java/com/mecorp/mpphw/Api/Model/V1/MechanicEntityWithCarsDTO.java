package com.mecorp.mpphw.Api.Model.V1;

import java.util.List;

public class MechanicEntityWithCarsDTO {

    private Integer id;
    private String firstName;

    private String secondName;

    private String brandExpertise;

    private String dateHired;

    private Integer salary;

    private List<CarEntityDTO> carEntityDTOList;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getBrandExpertise() {
        return brandExpertise;
    }

    public void setBrandExpertise(String brandExpertise) {
        this.brandExpertise = brandExpertise;
    }

    public String getDateHired() {
        return dateHired;
    }

    public void setDateHired(String dateHired) {
        this.dateHired = dateHired;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public List<CarEntityDTO> getCarEntityDTOList() {
        return carEntityDTOList;
    }

    public void setCarEntityDTOList(List<CarEntityDTO> carEntityDTOList) {
        this.carEntityDTOList = carEntityDTOList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
