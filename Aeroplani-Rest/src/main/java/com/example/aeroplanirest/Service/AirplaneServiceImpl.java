package com.example.aeroplanirest.Service;

import com.example.aeroplanirest.Model.Airplane;
import com.example.aeroplanirest.Repository.AirplaneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class AirplaneServiceImpl implements AirplaneService {

    private final AirplaneRepository airplaneRepository;



    public AirplaneServiceImpl(AirplaneRepository airplaneRepository) {
        this.airplaneRepository = airplaneRepository;
    }

    @Override
    public List<Airplane> getAllAirplanes() {
        return (List<Airplane>) airplaneRepository.findAll();
    }

    @Override
    public Optional<Airplane> getAirplaneById(Long id) {
        return airplaneRepository.findById(id);
    }

    @Override
    public Airplane createAirplane(Airplane airplane) {
        return airplaneRepository.save(airplane);
    }

    @Override
    public Optional<Airplane> updateAirplane(Long id, Airplane updatedAirplane) {
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(id);
        if (optionalAirplane.isPresent()) {
            Airplane existingAirplane = optionalAirplane.get();
            existingAirplane.setName(updatedAirplane.getName());
            existingAirplane.setManufacturer(updatedAirplane.getManufacturer());
            existingAirplane.setYear(updatedAirplane.getYear());
            Airplane savedAirplane = airplaneRepository.save(existingAirplane);
            return Optional.of(savedAirplane);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Airplane> partialUpdateAirplane(Long id, Airplane partialUpdate) {
        Optional<Airplane> optionalAirplane = airplaneRepository.findById(id);
        if (optionalAirplane.isPresent()) {
            Airplane existingAirplane = optionalAirplane.get();
            if (partialUpdate.getName() != null) {
                existingAirplane.setName(partialUpdate.getName());
            }
            if (partialUpdate.getManufacturer() != null) {
                existingAirplane.setManufacturer(partialUpdate.getManufacturer());
            }
            Airplane savedAirplane = airplaneRepository.save(existingAirplane);
            return Optional.of(savedAirplane);
        } else {
            return Optional.empty();
        }
    }

    @Override
    public boolean deleteAirplane(Long id) {
        if (airplaneRepository.existsById(id)) {
            airplaneRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}