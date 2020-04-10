package edu.uekat.pl.hotel.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class ReservationTest {

    @Autowired
    ReservationRepository reservationRepo;

    @Test
    @DisplayName("Find all reservations by date from year,month and day")
    @Transactional
    void FindAllReservationByDateFrom_YearMonthDay(){
        //given
        LocalDateTime date = LocalDateTime.of(2020, 4, 8, 0, 0);
        //when
        int reservations = reservationRepo.findByDateFromYearMonthDay(date).size();
        //then
        assertEquals(date, reservationRepo.findById(1L).get().getDateFrom());
    }

    @Test
    @DisplayName("find all reservations by date from month-day")
    @Transactional
    void findAllReservationsByDateFrom_YearMonth(){
        //given
        LocalDateTime date = LocalDateTime.of(2020, 4, 8, 0, 0);
        //when
        int reservations = reservationRepo.findByDateFromYearMonth(date).size();
        System.out.println(Arrays.toString(reservationRepo.findByDateFromYearMonth(date).toArray()));
        //then
        assertEquals(2, reservations);
    }
}
