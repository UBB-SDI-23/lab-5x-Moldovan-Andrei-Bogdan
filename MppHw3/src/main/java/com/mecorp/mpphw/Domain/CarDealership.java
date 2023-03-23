package com.mecorp.mpphw.Domain;

import com.mecorp.mpphw.Api.Model.V1.CarPart_CarDealershipRequestDTO;
import com.mecorp.mpphw.CompositeKeys.CarPartCarDealershipKey;
import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CAR_DEALERSHIP")
public class CarDealership {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "YEAR_FOUNDED")
    private Integer yearFounded;

    @Column(name = "ADDRESS")
    private String address;
    @OneToMany(mappedBy = "carDealership", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CarPart_CarDealership> carParts;

    @OneToMany(mappedBy = "carDealership")
    private List<Car> cars;

    public CarDealership() {}

    public CarDealership(String name, String phoneNumber, String email, Integer yearFounded, String address) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.yearFounded = yearFounded;
        this.address = address;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getYearFounded() {
        return yearFounded;
    }

    public void setYearFounded(Integer yearFounded) {
        this.yearFounded = yearFounded;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<CarPart_CarDealership> getCarParts() {
        return carParts;
    }

    public void setCarParts(List<CarPart_CarDealership> carParts) {
        this.carParts = carParts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarDealership that = (CarDealership) o;
        return id.equals(that.id) && name.equals(that.name) && phoneNumber.equals(that.phoneNumber) && email.equals(that.email) && yearFounded.equals(that.yearFounded) && address.equals(that.address) && carParts.equals(that.carParts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, phoneNumber, email, yearFounded, address, carParts);
    }

//    public void addCarPart(CarPart carPart, CarPart_CarDealershipRequestDTO carPart_carDealershipRequestDTO) {
////        PostTag postTag = new PostTag(this, tag);
////        tags.add(postTag);
////        tag.getPosts().add(postTag);
////        CarPartCarDealershipKey carPartCarDealershipKey = new CarPartCarDealershipKey();
////        carPartCarDealershipKey.setCarPartID(carPart.getId());
////        carPartCarDealershipKey.setCarDealershipID(this.getId());
////        CarPart_CarDealership carPart_carDealership = new CarPart_CarDealership();
////        carPart_carDealership.setId(carPartCarDealershipKey);
////        carPart_carDealership.setCarPart(carPart);
////        carPart_carDealership.setCarDealership(this);
////        CarPart_CarDealership carPart_carDealership = new CarPart_CarDealership(this, carPart);
////        carPart_carDealership.setQuantity(carPart_carDealershipRequestDTO.getQuantity());
////        carPart_carDealership.setShippedDate(carPart_carDealershipRequestDTO.getShippedDate());
////        this.carParts.add(carPart_carDealership);
////        carPart.getCarDealerships().add(carPart_carDealership);
//    }

//    public void removeTag(CarPart carPart) {
//        for (Iterator<CarPart_CarDealership> iterator = this.carParts.iterator();
//             iterator.hasNext(); ) {
//            CarPart_CarDealership carPart_carDealership = iterator.next();
//
//            if (carPart_carDealership.getCarDealership().equals(this) &&
//                    carPart_carDealership.getCarPart().equals(carPart)) {
//                iterator.remove();
//                carPart_carDealership.getCarPart().getCarDealerships().remove(carPart_carDealership);
//                carPart_carDealership.setCarDealership(null);
//                carPart_carDealership.setCarPart(null);
//            }
//        }
//    }
}
