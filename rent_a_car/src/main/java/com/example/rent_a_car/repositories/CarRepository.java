package com.example.rent_a_car.repositories;

import com.example.rent_a_car.models.Car;
import com.example.rent_a_car.models.CarType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Integer> {

    List<Car> findByCarType(CarType carType);
}
