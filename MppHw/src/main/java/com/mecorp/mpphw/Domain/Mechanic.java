package com.mecorp.mpphw.Domain;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.List;

@Entity
@Table(name = "MECHANIC")
public class Mechanic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "SECOND_NAME")
    private String secondName;

    @Column(name = "BRAND_EXPERTISE")
    private String brandExpertise;

    @Column(name = "DATE_HIRED")
    private String dateHired;

    @Column(name = "Salary")
    private Integer salary;

    @OneToMany(mappedBy = "mechanic")
    private List<Car> cars;

    public Mechanic() {}

    public Mechanic(String firstName, String secondName, String brandExpertise, String dateHired, Integer salary) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.brandExpertise = brandExpertise;
        this.dateHired = dateHired;
        this.salary = salary;
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

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
