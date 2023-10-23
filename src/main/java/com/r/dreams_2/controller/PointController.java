package com.r.dreams_2.controller;

import com.r.dreams_2.dto.PointDTO;
import com.r.dreams_2.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/points")
public class PointController {
    private final PointService service;
    @Autowired
    public PointController(PointService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @PostMapping("/createPoint")
    public ResponseEntity<PointDTO> createPoint(@RequestBody PointDTO pointDTO) {
        return ResponseEntity.ok(service.createPoint(pointDTO));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @GetMapping("/point/{pointId}")
    public ResponseEntity<Optional<PointDTO>> getPoint(@PathVariable("pointId") Long pointId) {
        return ResponseEntity.ok(service.getPoint(pointId));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @DeleteMapping("/{pointId}")
    public ResponseEntity<?> deletePoint(@PathVariable("pointId") Long pointId) {
        try {
            service.deletePoint(pointId);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
