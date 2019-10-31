package com.example.bootifiltesting;

import com.example.bootifiltesting.model.Reservation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.Collections;

@WebMvcTest
@ExtendWith(SpringExtension.class)
public class ReservationControllerTest {

    @MockBean
    private ReservationRepository reservationRepository;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservation() throws Exception {

        Mockito.when(this.reservationRepository.findAll())
            .thenReturn(Collections.singletonList(new Reservation(1L, "Jane")));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/reservations"))
            .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.jsonPath("@.[0].id").value(1L))
            .andExpect(MockMvcResultMatchers.jsonPath("@.[0].reservationName").value("Jane"))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
