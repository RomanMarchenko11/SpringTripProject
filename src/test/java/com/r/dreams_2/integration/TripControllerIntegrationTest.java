package com.r.dreams_2.integration;

import com.r.dreams_2.dto.TripDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Base64;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class TripControllerIntegrationTest {
    private final TestRestTemplate restTemplate = new TestRestTemplate();

    @Test
    public void testGetTrip() {
        String url = "http://localhost:" + "8080" + "/api/trips/trip/1";
        String author = "traveller:trip2023";
        String encodeAuth = Base64.getEncoder().encodeToString(author.getBytes());
        String authHeader = "Basic" + encodeAuth;

        org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.set("Authorization", authHeader);
        HttpEntity<TripDTO> entity = new HttpEntity<>(headers);

        ResponseEntity<TripDTO> response = restTemplate.exchange(url, HttpMethod.GET, entity, TripDTO.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1L, response.getBody());
    }
}
