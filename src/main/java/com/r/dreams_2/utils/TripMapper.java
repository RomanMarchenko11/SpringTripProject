package com.r.dreams_2.utils;

import com.r.dreams_2.dto.TripDTO;
import com.r.dreams_2.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {
    public TripDTO toDTO(Trip trip) {
        TripDTO dtoTrip = new TripDTO();
        dtoTrip.setId (trip.getId());
        dtoTrip.setName(trip.getName());
        dtoTrip.setDescription(trip.getDescription());
        dtoTrip.setPoint(trip.getPoint());
        return dtoTrip;
    }

    public Trip toEntity(TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setId(tripDTO.getId());
        trip.setName(tripDTO.getName());
        trip.setDescription(tripDTO.getDescription());
        trip.setPoint(tripDTO.getPoint());
        trip.setTraveller(tripDTO.getTraveller());
        return trip;
    }
}
