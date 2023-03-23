package com.mecorp.mpphw.Api.Model.V1;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class MechanicWithMostCarsDTO {

    private Integer id;

    private String firstName;

    private String secondName;

    private String brandExpertise;

    private String dateHired;

    private Integer salary;

    private Integer numberOfCars;

    public MechanicWithMostCarsDTO(Integer id, String firstName, String secondName, String brandExpertise, String dateHired, Integer salary, Integer numberOfCars) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.brandExpertise = brandExpertise;
        this.dateHired = dateHired;
        this.salary = salary;
        this.numberOfCars = numberOfCars;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getNumberOfCars() {
        return numberOfCars;
    }

    public void setNumberOfCars(Integer numberOfCars) {
        this.numberOfCars = numberOfCars;
    }
}
