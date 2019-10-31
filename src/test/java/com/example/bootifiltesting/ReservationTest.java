package com.example.bootifiltesting;


import com.example.bootifiltesting.model.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;

public class ReservationTest {

    @Test
    public void creation(){

        Reservation r = new Reservation(1L, "Jane");
        //Assert.assertEquals(r.getId(), (Long)1L);
//        assertThat(r.getId(), (Long)1L);
        Assertions.assertThat(r.getId()).isEqualTo(1L);
        Assertions.assertThat(r.getReservationName()).isNotBlank();
        Assertions.assertThat(r.getReservationName()).isEqualTo("Jane");

    }
}
