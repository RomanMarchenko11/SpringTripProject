package com.r.dreams_2.unit;

import com.r.dreams_2.dto.TripDTO;
import com.r.dreams_2.entity.Trip;
import com.r.dreams_2.utils.TripMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripMapperTest {
    private TripMapper tripMapper = new TripMapper();

    @BeforeEach
    public void setup() {
        tripMapper = new TripMapper();
    }

    @Test
    public void testToTDO() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("Europe Tour");
        trip.setDescription("Visited a few countries");

        TripDTO tripTest = tripMapper.toDTO(trip);

        assertEquals(1L,tripTest.getId());
        assertEquals("Europe Tour", tripTest.getName());
        assertEquals("Visited a few countries",tripTest.getDescription());
    }

    @Test
    public void testToEntity() {
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("Europe Tour");
        tripDTO.setDescription("Visited a few countries");

        Trip trip = tripMapper.toEntity(tripDTO);

        assertEquals(1L,trip.getId());
        assertEquals("Europe Tour", trip.getName());
        assertEquals("Visited a few countries",trip.getDescription());
    }
}

