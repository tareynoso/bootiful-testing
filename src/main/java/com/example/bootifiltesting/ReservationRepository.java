package com.example.bootifiltesting;

import com.example.bootifiltesting.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    public Collection<Reservation> findReservationByReservationName(String name);
}
