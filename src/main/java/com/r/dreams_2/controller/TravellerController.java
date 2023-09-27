package com.r.dreams_2.controller;
/*
1. Доповнити Spring Boot проект з попереднього заняття контролером,
    який буде повертати по id / name / email юзера. Так само контролер
    має вміти видаляти / оновлювати юзера.  Запит має працювати через PostMan
2. Доповнити Spring Boot проект Spring Security Configuration класом і додати
    новий бін Role, додати захист для UserConroller (юзер без ролі USER) - не має мати доступу.
 */

import com.r.dreams_2.dto.TravellerDTO;
import com.r.dreams_2.entity.Traveller;
import com.r.dreams_2.service.TravellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/travellers")
public class TravellerController {
    private final TravellerService service;

    @Autowired
    public TravellerController(TravellerService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @RequestMapping("/traveller")
    public String getTraveller() {
        return "Hello Traveller";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin")
    public String getAdminInfo() {
        return "Hello admin";
    }

    @PreAuthorize("hasRole('TRAVELLER')")
    @PostMapping("/requestBody")
    public ResponseEntity<TravellerDTO> postTraveller(@RequestBody TravellerDTO travellerDTO){
        return ResponseEntity.ok(service.createTraveller(travellerDTO));
    }

}
