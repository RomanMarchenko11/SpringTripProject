package com.r.dreams_2.integration;

import com.r.dreams_2.service.TripServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(roles = "TRAVELLER")
public class TripControllerIntegrationMockMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TripServiceImpl tripService;

    @Test
    public void testGetTrip() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/trips/info"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hello new Trip! )) "));
    }
}
