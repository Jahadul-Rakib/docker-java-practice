package com.example.testproject.container;


import com.example.testproject.domain.CarInformation;
import com.example.testproject.web_service.CarInfoService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("car")
@AllArgsConstructor
public class CarController {
    private final CarInfoService infoService;

    @PostMapping
    public ResponseEntity<?> createCarInsert(@RequestBody CarInformation information){
        return ResponseEntity.ok().body(infoService.createCar(information));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCarInformation(@PathVariable(value = "id") Long id){
        return ResponseEntity.ok().body(infoService.getCarById(id));
    }
    @GetMapping
    public ResponseEntity<?> getAllCarInformation() throws NotFoundException {
        return ResponseEntity.ok().body(infoService.getAllCars());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCarInformation(@PathVariable(value = "id") Long id){
        infoService.deleteCar(id);
        return ResponseEntity.ok().body("Done!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
    }
}
