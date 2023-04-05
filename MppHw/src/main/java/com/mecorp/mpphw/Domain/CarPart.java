package com.mecorp.mpphw.Domain;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CARPART")
public class CarPart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "YEAR_APPEARED")
    private Integer yearAppeared;

    @OneToMany(mappedBy = "carPart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarPart_CarDealership> carDealerships;

    public CarPart() {}

    public CarPart(String name, Integer yearAppeared) {
        this.name = name;
        this.yearAppeared = yearAppeared;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public List<CarPart_CarDealership> getCarDealerships() {
        return carDealerships;
    }

    public void setCarDealerships(List<CarPart_CarDealership> carDealerships) {
        this.carDealerships = carDealerships;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPart carPart = (CarPart) o;
        return id.equals(carPart.id) && name.equals(carPart.name) && yearAppeared.equals(carPart.yearAppeared) && carDealerships.equals(carPart.carDealerships);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, yearAppeared, carDealerships);
    }
}
