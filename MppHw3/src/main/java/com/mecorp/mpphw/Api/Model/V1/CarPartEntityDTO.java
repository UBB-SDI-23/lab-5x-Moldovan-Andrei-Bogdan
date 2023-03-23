package com.mecorp.mpphw.Api.Model.V1;

public class CarPartEntityDTO {

    private Integer id;
    private String name;
    private Integer yearAppeared;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getYearAppeared() {
        return yearAppeared;
    }

    public void setYearAppeared(Integer yearAppeared) {
        this.yearAppeared = yearAppeared;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
