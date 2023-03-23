package com.mecorp.mpphw.Repository;

import com.mecorp.mpphw.Domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Integer> {
}
