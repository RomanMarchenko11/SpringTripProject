package com.r.dreams_2.utils;

import com.r.dreams_2.dto.TravellerDTO;
import com.r.dreams_2.entity.Traveller;
import org.springframework.stereotype.Component;

@Component
public class TravellerMapper {

    public TravellerDTO toDTO(Traveller traveller) {
        TravellerDTO dtoTraveller = new TravellerDTO();
        dtoTraveller.setId(traveller.getId());
        dtoTraveller.setEmail(traveller.getName());
        dtoTraveller.setName(traveller.getSurname());
        dtoTraveller.setEmail(traveller.getEmail());
        return dtoTraveller;
    }

    public Traveller toEntity(TravellerDTO travellerDTO) {
        Traveller traveller = new Traveller();
        traveller.setId(travellerDTO.getId());
        traveller.setEmail(travellerDTO.getName());
        traveller.setName(travellerDTO.getSurname());
        traveller.setEmail(travellerDTO.getEmail());
        // Перетворення інших полів за потребою
        return traveller;
    }

}
