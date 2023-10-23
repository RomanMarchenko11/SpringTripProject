package com.r.dreams_2.utils;

import com.r.dreams_2.dto.TravellerDTO;
import com.r.dreams_2.entity.Traveller;
import org.springframework.stereotype.Component;

@Component
public class TravellerMapper {

    public TravellerDTO toDTO(Traveller traveller) {
        TravellerDTO dtoTraveller = new TravellerDTO();
        dtoTraveller.setId(traveller.getId());
        dtoTraveller.setName(traveller.getName());
        dtoTraveller.setSurname(traveller.getSurname());
        dtoTraveller.setEmail(traveller.getEmail());
        dtoTraveller.setPassword(traveller.getPassword());
        dtoTraveller.setAddress(traveller.getAddress());
        dtoTraveller.setTrip(traveller.getTrip());
        return dtoTraveller;
    }

    public Traveller toEntity(TravellerDTO travellerDTO) {
        Traveller traveller = new Traveller();
        traveller.setId(travellerDTO.getId());
        traveller.setName(travellerDTO.getName());
        traveller.setSurname(travellerDTO.getSurname());
        traveller.setEmail(travellerDTO.getEmail());
        traveller.setPassword(travellerDTO.getPassword());
        traveller.setAddress(travellerDTO.getAddress());
        traveller.setTrip(travellerDTO.getTrip());
        return traveller;
    }
}
