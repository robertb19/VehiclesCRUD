package com.bialas.robert.sankhyacrud.Vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.constraints.Null;
import java.io.IOException;
import java.net.URI;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VehicleResource {

    @Autowired
    private VehicleRepository vehicleRepository;


    @GetMapping("/vehicles")
    public List<Vehicle> retrieveAllVehicles() {
        return vehicleRepository.findAll();
    }

    @GetMapping("/vehicles/{id}")
    public Vehicle retrieveVehicle(@PathVariable long id) throws IOException {

        if(vehicleRepository.existsById(id)){
            Optional<Vehicle> vehicle = vehicleRepository.findById(id);
            return vehicle.get();
        }

        else throw new IOException("id-" + id);

    }

    @DeleteMapping("/vehicles/{id}")
    public void deleteVehicle(@PathVariable long id) throws IOException {

        if(vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
        }
        else throw new IOException();
    }

    @DeleteMapping("/vehicles/assembler/{id}")
    public void deleteAssemblerFromVehicle(@PathVariable long id) throws IOException {

        if(vehicleRepository.existsById(id)){
        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
        Vehicle c = vehicleOptional.get();
        c.setMake(null);
        vehicleRepository.save(c);}
        else throw new IOException();
    }

    @DeleteMapping("/vehicles/model/{id}")
    public void deleteModelFromVehicle(@PathVariable long id) throws IOException {

        if(vehicleRepository.existsById(id)){
            Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
            Vehicle c = vehicleOptional.get();
            c.setModel(null);
            vehicleRepository.save(c);}
        else throw new IOException();
    }

    @PutMapping("/vehicles/model/{id}")
    public void editModelInVehicle(@PathVariable long id, @RequestBody String model) throws IOException {

        if(vehicleRepository.existsById(id)){
            Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
            Vehicle c = vehicleOptional.get();
            c.setModel(model);
            vehicleRepository.save(c);}
        else throw new IOException();
    }

    @PutMapping("/vehicles/assembler/{id}")
    public void editMakeInVehicle(@PathVariable long id, @RequestBody String make) throws IOException {

        if(vehicleRepository.existsById(id)){
            Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);
            Vehicle c = vehicleOptional.get();
            c.setMake(make);
            vehicleRepository.save(c);}
        else throw new IOException();
    }


    @PostMapping("/vehicles")
    public ResponseEntity<Object> createVehicle(@RequestBody Vehicle vehicle) throws IOException {

            Vehicle vehicle1 = vehicleRepository.save(vehicle);
            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(vehicle.getId()).toUri();
            return ResponseEntity.created(location).build();


    }

  @PutMapping("/vehicles/{id}")
    public ResponseEntity<Object> updateVehicle(@RequestBody Vehicle vehicle, @PathVariable long id) {

        Optional<Vehicle> vehicleOptional = vehicleRepository.findById(id);

        if (!vehicleOptional.isPresent())
            return ResponseEntity.notFound().build();

        vehicle.setId(id);

        vehicleRepository.save(vehicle);

        return ResponseEntity.noContent().build();
    }
}