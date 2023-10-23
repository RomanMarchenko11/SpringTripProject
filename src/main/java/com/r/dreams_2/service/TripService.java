package com.r.dreams_2.service;

import com.r.dreams_2.dto.TripDTO;
import java.util.Optional;

public interface TripService {
    TripDTO createTrip (TripDTO tripDTO);
    Optional<TripDTO> getTrip (Long id);
    TripDTO updateTrip(TripDTO tripDTO, Long id);
    void deleteTrip(Long id);
//    List<Point> findAllpoints (Long Tripid);
//    List<TripDTO> findAllTrips();
}
