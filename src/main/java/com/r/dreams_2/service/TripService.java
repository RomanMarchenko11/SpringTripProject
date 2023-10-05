package com.r.dreams_2.service;

import com.r.dreams_2.dto.TripDTO;
import com.r.dreams_2.entity.Trip;

import java.util.List;
import java.util.Optional;

public interface TripService {
    TripDTO createTrip (TripDTO tripDTO);
    Optional<Trip> getTrip (Long id);
    TripDTO updateTrip(TripDTO tripDTO, Long id);
    TripDTO deleteTrip(Long id);
//    List<TripDTO> findAllPoints();
}
