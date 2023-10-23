package com.r.dreams_2.controller;

import com.r.dreams_2.dto.TripDTO;
import com.r.dreams_2.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/trips")
public class TripController {
    private final TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @GetMapping("/trip/{tripId}")
    public ResponseEntity<Optional<TripDTO>> getTrip(@PathVariable("tripId") Long tripId) {
        return ResponseEntity.ok(tripService.getTrip(tripId));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @PostMapping("/createTrip")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDTO) {
        return ResponseEntity.ok(tripService.createTrip(tripDTO));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @DeleteMapping("/{tripId}")
    public ResponseEntity<?> deleteTrip(@PathVariable("tripId") Long tripId) {
        try {
            tripService.deleteTrip(tripId);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
