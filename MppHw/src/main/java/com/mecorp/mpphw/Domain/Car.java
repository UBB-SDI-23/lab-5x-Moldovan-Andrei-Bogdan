package com.mecorp.mpphw.Domain;

import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;

@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ENGINE_CAPACITY")
    private Integer engineCC;

    @Column(name = "ENGINE_TYPE")
    private String engineType;

    @Column(name = "ENGINE_HORSEPOWER")
    private Integer engineHP;

    @Column(name = "BRAND")
    private String brand;

    @Column(name = "MODEL")
    private String model;

    @Column(name = "COLOR")
    private String color;

    @ManyToOne
    @JoinColumn(name = "MECHANIC_ID", columnDefinition = "integer default -1")
    private Mechanic mechanic;

    @ManyToOne
    @JoinColumn(name = "CAR_DEALERSHIP_ID")
    private CarDealership carDealership;

    public Car() {}

    public Car(Integer engineCC, String engineType, Integer engineHP, String brand, String model, String color) {
        this.engineCC = engineCC;
        this.engineType = engineType;
        this.engineHP = engineHP;
        this.brand = brand;
        this.model = model;
        this.color = color;
    }

    public CarDealership getCarDealership() {
        return carDealership;
    }

    public void setCarDealership(CarDealership carDealership) {
        this.carDealership = carDealership;
    }

    public Mechanic getMechanic() {
        return mechanic;
    }

    public void setMechanic(Mechanic mechanic) {
        this.mechanic = mechanic;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEngineCC() {
        return engineCC;
    }

    public void setEngineCC(Integer engineCC) {
        this.engineCC = engineCC;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getEngineHP() {
        return engineHP;
    }

    public void setEngineHP(Integer engineHP) {
        this.engineHP = engineHP;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
