package com.example.bootifiltesting;

import com.example.bootifiltesting.model.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.Collections;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ReservationRepositoryTest {

    @Autowired
    private ReservationRepository repository;

    @Test
    public void findeByReservationName(){

        this.repository.save(new Reservation(null, "Jane"));
        Collection<Reservation> jane = this.repository.findReservationByReservationName("Jane");
        Assertions.assertThat(jane.size()).isEqualTo(1);
        Assertions.assertThat(jane.iterator().next().getId()).isGreaterThan(0);
        Assertions.assertThat(jane.iterator().next().getReservationName()).isEqualTo("Jane");



    }
}
