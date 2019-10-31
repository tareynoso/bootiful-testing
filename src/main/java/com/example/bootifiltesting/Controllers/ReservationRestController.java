package com.example.bootifiltesting.Controllers;

import com.example.bootifiltesting.ReservationRepository;
import com.example.bootifiltesting.model.Reservation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Collections;

@RestController
public class ReservationRestController {

    public ReservationRepository reservationRepository;

    public ReservationRestController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping("/reservations")
    Collection<Reservation> reservations (){
        return this.reservationRepository.findAll();
    }
}
