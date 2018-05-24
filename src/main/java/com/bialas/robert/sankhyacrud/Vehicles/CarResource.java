package com.bialas.robert.sankhyacrud.Vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class CarResource {

    @Autowired
    private CarRepository carRepository;

    @GetMapping("/cars")
    public List<Car> retrieveAllCars() {
        return carRepository.findAll();
    }

    @GetMapping("/cars/{id}")
    public Car retrieveCar(@PathVariable long id) throws IOException {
        Optional<Car> car = carRepository.findById(id);

        if (!car.isPresent())
            throw new IOException("id-" + id);

        return car.get();
    }

    @DeleteMapping("/cars/{id}")
    public void deleteVehicle(@PathVariable long id) {
        carRepository.deleteById(id);
    }

    @PostMapping("/cars")
    public ResponseEntity<Object> createVehicle(@RequestBody Car car) {
        Car car1 = carRepository.save(car);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(car1.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Object> updateVehicle(@RequestBody Car car, @PathVariable long id) {

        Optional<Car> carOptional = carRepository.findById(id);

        if (!carOptional.isPresent())
            return ResponseEntity.notFound().build();

        car.setId(id);

        carRepository.save(car);

        return ResponseEntity.noContent().build();
    }
}