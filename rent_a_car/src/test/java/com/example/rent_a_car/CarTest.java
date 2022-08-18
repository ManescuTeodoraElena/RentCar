package com.example.rent_a_car;

import com.example.rent_a_car.exceptions.EconomicCarException;
import com.example.rent_a_car.models.Car;
import com.example.rent_a_car.models.CarType;
import com.example.rent_a_car.repositories.CarRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CarTest {

    @Autowired
    private CarRepository carRepository;
    @Test
    @Rollback(false)
    public void testCreateCar(){
        Car car = new Car("Toyota", "Hibrid", 1.5, "Neagra", CarType.ECONOMY);
        Car savedCar = carRepository.save(car);

        assertNotNull(savedCar);
    }


}
