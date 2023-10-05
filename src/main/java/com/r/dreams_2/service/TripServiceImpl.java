package com.r.dreams_2.service;

import com.r.dreams_2.dto.TripDTO;
import com.r.dreams_2.entity.Trip;
import com.r.dreams_2.exceptions.CustomException;
import com.r.dreams_2.repository.TripRepository;
import com.r.dreams_2.utils.TripMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TripServiceImpl implements TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Transactional
    @Override
    public TripDTO createTrip (TripDTO tripDTO) {
        Trip trip = tripMapper.toEntity(tripDTO);
//        trip = tripRepository.save(trip);  //робиться автоматично
        return tripMapper.toDTO(trip);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Trip> getTrip (Long id) {
        return tripRepository.findById(id);
    }
    @Transactional
    @Override
    public TripDTO updateTrip(TripDTO tripDTO, Long id) {
        if (tripRepository.existsById(id)) {
            Trip trip = tripMapper.toEntity(tripDTO);
            trip.setId(id);
//            trip = tripRepository.save(trip);
            return tripMapper.toDTO(trip);
        }
        return null;
    }

    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public TripDTO deleteTrip(Long id) {
        tripRepository.deleteById(id);
        throw new CustomException("Deleted wrong", 500);
    }

//    @Transactional(readOnly = true)
//    @Override
//    public Optional<TripDTO> findAllPoints(Long id) {
//        return tripRepository.findAllById(id).map(tripMapper::toDTO);
//    }
}
