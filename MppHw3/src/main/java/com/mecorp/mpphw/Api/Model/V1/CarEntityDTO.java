package com.mecorp.mpphw.Api.Model.V1;

public class CarEntityDTO {

    private Integer id;
    private Integer engineCC;
    private String engineType;
    private Integer engineHP;
    private String brand;
    private String model;
    private String color;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
