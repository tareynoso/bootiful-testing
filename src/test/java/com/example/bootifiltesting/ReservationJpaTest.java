package com.example.bootifiltesting;

import com.example.bootifiltesting.model.Reservation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@DataJpaTest
@ExtendWith(SpringExtension.class)
public class ReservationJpaTest {

    @Autowired
    private TestEntityManager tem;

    @Test
    public void mapping(){
        Reservation jane = this.tem.persistAndFlush(new Reservation(null, "Jane"));
        Assertions.assertThat(jane.getReservationName()).isEqualTo("Jane");
        Assertions.assertThat(jane.getId()).isNotNull();
        Assertions.assertThat(jane.getId()).isGreaterThan(0);
    }
}

