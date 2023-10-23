package com.r.dreams_2.service;

import com.r.dreams_2.dto.TravellerDTO;

import java.util.List;
import java.util.Optional;

public interface TravellerService {
    Optional<TravellerDTO> getTraveller(Long id);
    TravellerDTO createTraveller (TravellerDTO travellerDTO);
    TravellerDTO updateTraveller(Long id, TravellerDTO travellerDTO);
    void deleteTraveller(Long id);
    List<TravellerDTO> findAllTravellers();
}
