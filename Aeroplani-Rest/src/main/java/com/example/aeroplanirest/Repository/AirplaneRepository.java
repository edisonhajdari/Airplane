package com.example.aeroplanirest.Repository;

import com.example.aeroplanirest.Model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface AirplaneRepository extends JpaRepository<Airplane, Long> {

}