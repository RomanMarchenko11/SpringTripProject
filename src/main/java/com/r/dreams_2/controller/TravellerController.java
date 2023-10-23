package com.r.dreams_2.controller;

import com.r.dreams_2.dto.TravellerDTO;
import com.r.dreams_2.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/travellers")
public class TravellerController {
    private final TravellerService service;

    @Autowired
    public TravellerController(TravellerService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @GetMapping("/traveller/{travellerId}")
    public ResponseEntity<Optional<TravellerDTO>> getTraveller(@PathVariable("travellerId") Long travellerId) {
        return ResponseEntity.ok(service.getTraveller(travellerId));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @PostMapping("/createTraveller")
    public ResponseEntity<TravellerDTO> createTraveller(@RequestBody TravellerDTO travellerDTO) {
        return ResponseEntity.ok(service.createTraveller(travellerDTO));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @DeleteMapping("/{travellerId}")
//    public void deleteTraveller(@PathVariable("travellerId") Long travellerId) {
//        service.deleteTraveller(travellerId);
    public ResponseEntity<?> deleteTraveller(@PathVariable("travellerId") Long travellerId) {
        try {
            service.deleteTraveller(travellerId);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
//        boolean exist = service.deleteTraveller(travellerId);
//        if (exist) {
//            return ResponseEntity.noContent().build(); // Відповідь зі статусом 200 OK, якщо користувача видалено.
//        } else {
//            return ResponseEntity.ok().build(); // Відповідь зі статусом 404 Not Found, якщо користувача з таким ID не знайдено.
//        }
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @PatchMapping("/update/{travellerId}")
    public ResponseEntity<TravellerDTO> updateTraveller(@RequestBody TravellerDTO travellerDTO, @PathVariable Long travellerId) {
        try {
            return ResponseEntity.ok(service.updateTraveller(travellerId,travellerDTO));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.noContent().build();
        }
//        return ResponseEntity.ok(service.updateTraveller(travellerId, travellerDTO));
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @PutMapping("/update1/{travellerId}")
    public ResponseEntity<TravellerDTO> update1Traveller(@PathVariable("travellerId") Long travellerId, @RequestBody TravellerDTO travellerDTO) {
        try {
            return ResponseEntity.ok(service.updateTraveller(travellerId,travellerDTO));
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.noContent().build();
        }
//        return ResponseEntity.ok(service.updateTraveller(travellerId, travellerDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminInfo() {
        return "Hello admin";
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @GetMapping("/traveller")
    public String getTraveller() {
        return "Hello Traveller";
    }
}
