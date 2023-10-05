package com.r.dreams_2.controller;

import com.r.dreams_2.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/trips")
public class TripController {
        private final TripService service;

        @Autowired
        public TripController(TripService service) {
            this.service = service;
        }

        @PreAuthorize("hasRole('TRAVELLER')")
        @RequestMapping("/info")
        public String getTrip() {
            return "Hello new Trip!";
        }
    }
