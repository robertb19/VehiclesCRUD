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
public class MotorcycleResource {

    @Autowired
    private MotorcycleRepository motorcycleRepository;

    @GetMapping("/motorcycles")
    public List<Motorcycle> retrieveAllVehicles() {
        return motorcycleRepository.findAll();
    }

    @GetMapping("/motorcycles/{id}")
    public Motorcycle retrieveMotorcycle(@PathVariable long id) throws IOException {
        Optional<Motorcycle> motorcycle = motorcycleRepository.findById(id);

        if (!motorcycle.isPresent())
            throw new IOException("id-" + id);

        return motorcycle.get();
    }

    @DeleteMapping("/motorcycles/{id}")
    public void deleteMotorcycle(@PathVariable long id) {
        motorcycleRepository.deleteById(id);
    }

    @PostMapping("/motorcycles")
    public ResponseEntity<Object> createMotorcycle(@RequestBody Motorcycle motorcycle) {
        Motorcycle motorcycle1 = motorcycleRepository.save(motorcycle);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(motorcycle.getId()).toUri();

        return ResponseEntity.created(location).build();

    }

    @PutMapping("/motorcycles/{id}")
    public ResponseEntity<Object> updateMotorcycle(@RequestBody Motorcycle motorcycle, @PathVariable long id) {

        Optional<Motorcycle> motorcycleOptional = motorcycleRepository.findById(id);

        if (!motorcycleOptional.isPresent())
            return ResponseEntity.notFound().build();

        motorcycle.setId(id);

        motorcycleRepository.save(motorcycle);

        return ResponseEntity.noContent().build();
    }
}