package com.r.dreams_2.unit;

import com.r.dreams_2.dto.TripDTO;
import com.r.dreams_2.entity.Trip;
import com.r.dreams_2.repository.TripRepository;
import com.r.dreams_2.service.TripServiceImpl;
import com.r.dreams_2.utils.TripMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TripServiceImplTest {
    @Mock
    private TripRepository tripRepository;

    @Spy
    private TripMapper tripMapper;

    @InjectMocks
    private TripServiceImpl tripService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTrip() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("One day");
        trip.setDescription("Trip to Zakarpatya");

        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("One day");
        tripDTO.setDescription("Trip to Zakarpatya");

        when(tripRepository.save(any())).thenReturn(trip);

        TripDTO resultDTO = tripService.createTrip(tripDTO);

        verify(tripRepository, times(1)).save(any(Trip.class));
        assertEquals(1L, resultDTO.getId());

        verify(tripMapper, times(1)).toEntity(tripDTO);
        verify(tripMapper, times(1)).toDTO(trip);
    }

    @Test
    public void GetTrip(){
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("One day");
        trip.setDescription("Trip to Zakarpatya");

        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("One day");
        tripDTO.setDescription("Trip to Zakarpatya");

        given(tripRepository.findById(1L)).willReturn(Optional.of(trip));

        Optional<Trip> resultDTO = tripService.getTrip(1L);

        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());

        verify(tripMapper, times(1)).toDTO(trip);

    }
}
