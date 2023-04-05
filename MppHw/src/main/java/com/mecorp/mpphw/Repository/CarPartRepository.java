package com.mecorp.mpphw.Repository;

import com.mecorp.mpphw.Domain.CarPart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarPartRepository extends JpaRepository<CarPart, Integer> {
}
