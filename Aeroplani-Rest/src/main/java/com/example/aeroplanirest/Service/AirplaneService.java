package com.example.aeroplanirest.Service;

import com.example.aeroplanirest.Model.Airplane;

import java.util.List;
import java.util.Optional;

public interface AirplaneService {

    List<Airplane> getAllAirplanes();

    Optional<Airplane> getAirplaneById(Long id);

    Airplane createAirplane(Airplane airplane);

    Optional<Airplane> updateAirplane(Long id, Airplane updatedAirplane);

    Optional<Airplane> partialUpdateAirplane(Long id, Airplane partialUpdate);

    boolean deleteAirplane(Long id);
}
