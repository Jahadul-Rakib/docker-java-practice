package com.example.testproject.web_service.services;

import com.example.testproject.domain.CarInformation;
import com.example.testproject.repository.CarInformationRepository;
import com.example.testproject.web_service.CarInfoService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CarInformationServiceImpl implements CarInfoService {

    private final CarInformationRepository informationRepository;

    @Override
    public CarInformation createCar(CarInformation information) {
        return informationRepository.save(information);
    }

    @Override
    public Optional<CarInformation> getCarById(Long carId) {
        return informationRepository.findById(carId);
    }

    @Override
    public List<CarInformation> getAllCars() throws NotFoundException {
        List<CarInformation> informationList = informationRepository.findAll();
        if (informationList.isEmpty()){
         throw new NotFoundException("No data found");
        }
        return informationList;
    }

    @Override
    public void deleteCar(Long carId) {
        informationRepository.deleteById(carId);
    }
}
