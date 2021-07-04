package com.example.testproject.web_service;

import com.example.testproject.domain.CarInformation;
import javassist.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface CarInfoService {
    CarInformation createCar(CarInformation information);
    Optional<CarInformation> getCarById(Long carId);
    List<CarInformation> getAllCars() throws NotFoundException;
    void deleteCar(Long carId);
}
