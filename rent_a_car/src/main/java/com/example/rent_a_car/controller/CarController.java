package com.example.rent_a_car.controller;

import com.example.rent_a_car.models.Car;
import com.example.rent_a_car.models.CarType;
import com.example.rent_a_car.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @PostMapping("/add")
    public String addCar(@RequestBody Car car){
        try {
            carService.saveCar(car);
            return "Masina cu marca " +car.getBrand()  + " a fost adugata cu succes" ;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    @GetMapping("getbytype/{type}")
    public List<Car> getCarsByType(@PathVariable("type") CarType type){
        return carService.getCarListByType(type);
    }

    @GetMapping("all")
    public List<Car> getAllCars(){
        return carService.getAllCars();
    }
}
