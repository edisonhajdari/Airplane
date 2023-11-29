package com.example.aeroplanirest.Controller;

import com.example.aeroplanirest.Model.Airplane;
import com.example.aeroplanirest.Service.AirplaneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin
@RequestMapping("/airplanes")
public class AirplaneController {

    @Autowired
    private AirplaneServiceImpl airplaneService;

    @GetMapping
    public List<Airplane> getAllAirplanes() {
        return airplaneService.getAllAirplanes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Airplane> getAirplaneById(@PathVariable Long id) {
        Optional<Airplane> optionalAirplane = airplaneService.getAirplaneById(id);
        return optionalAirplane.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Airplane> createAirplane(@RequestBody Airplane airplane) {
        Airplane savedAirplane = airplaneService.createAirplane(airplane);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAirplane);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Airplane> updateAirplane(@PathVariable Long id, @RequestBody Airplane updatedAirplane) {
        Optional<Airplane> optionalUpdatedAirplane = airplaneService.updateAirplane(id, updatedAirplane);
        return optionalUpdatedAirplane.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Airplane> partialUpdateAirplane(
            @PathVariable Long id,
            @RequestBody Airplane partialUpdate) {
        Optional<Airplane> optionalUpdatedAirplane = airplaneService.partialUpdateAirplane(id, partialUpdate);
        return optionalUpdatedAirplane.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAirplane(@PathVariable Long id) {
        boolean deleted = airplaneService.deleteAirplane(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}