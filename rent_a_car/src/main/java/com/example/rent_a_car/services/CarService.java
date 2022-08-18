package com.example.rent_a_car.services;

import com.example.rent_a_car.exceptions.CarNotFoundException;
import com.example.rent_a_car.exceptions.EconomicCarException;
import com.example.rent_a_car.exceptions.StandardCarException;
import com.example.rent_a_car.exceptions.SuvCarException;
import com.example.rent_a_car.models.CarType;
import com.example.rent_a_car.repositories.CarRepository;
import com.example.rent_a_car.models.Car;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CarService {
    @Autowired
    private CarRepository carRepository;


    public List<Car> getCarListByType(CarType carType){
        List<Car> carList = carRepository.findByCarType(carType);
        return carList;
    }

    public List<Car> getAllCars(){
        List<Car> carList = (List<Car>) carRepository.findAll();
        return carList;
    }


    public Car getCarById(int id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(id);
        return car.orElseThrow(() ->new  CarNotFoundException("Nu exista nicio masina cu marca aceasta"));
    }

    public Car saveCar(Car car) throws EconomicCarException, StandardCarException, SuvCarException {
        if(car.getCarType().name().equals("ECONOMY") && car.getPrice() > 18){
            throw new EconomicCarException("Va rugam sa introduceti un pret mai mic decat 18");
        }else if(car.getCarType().name().equals("STANDARD") && car.getPrice() > 30){
            throw new StandardCarException("Va rugam sa introduceti un pret mai mic decat 30");
        }else if(car.getCarType().name().equals("SUV") && car.getPrice()<33){
            throw new SuvCarException("Va rugam sa introduceti un pret mai mare decat 33");
        }else {
            car.setBrand(car.getBrand());
            car.setModel(car.getModel());
            car.setPrice(car.getPrice());
            car.setColor(car.getColor());
            car.setCarType(car.getCarType());
            carRepository.save(car);
            return car;
        }
    }

}
