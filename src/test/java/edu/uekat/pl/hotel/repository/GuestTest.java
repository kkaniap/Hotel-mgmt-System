package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Guest;
import edu.uekat.pl.hotel.model.Reservation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GuestTest {

    @Autowired
    GuestRepository guestRepository;

    @Test
    @DisplayName("Save and find by ID number")
    void saveGuestAndFindByIdNumber(){
        //given
        Guest g1 = new Guest("APY2231", "Patryk", "Kania", true, "Poland", "Tychy", "Zimna 10", "43-100", LocalDate.now()
                ,"xkaniax@gmail.com", "558452145");
        //when
        guestRepository.save(g1);
        Optional<Guest> guest = guestRepository.findByIdNumber("APY2231");
        //then
        assertEquals("APY2231", guest.get().getIdNumber());
    }

    @Test
    @DisplayName("Find not existing guest by ID number")
    void findByIdNumberIsNull(){
        //given
        String idNumber = "KK23321";
        //when
        Optional<Guest> result = guestRepository.findByIdNumber(idNumber);
        //then
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Save and find by first and last name")
    void findByFirstAndLastName(){
        //given
        String name = "Karol";
        String lastName = "Kania";
        //when
        Optional<Guest> result = guestRepository.findByFirstNameAndLastName(name, lastName);
        //then
        assertTrue(result.isPresent());
        assertEquals(name.toLowerCase(), result.get().getFirstName().toLowerCase());
        assertEquals(lastName.toLowerCase(), result.get().getLastName().toLowerCase());
    }

    @Test
    @DisplayName("Save guest with reservations and find them")
    @Transactional
    void saveAndFindFindAllReservations(){
        //given
        Optional<Guest> guest = guestRepository.findById(1L);
        Reservation reservation = new Reservation(LocalDateTime.of(2020,3, 21, 10, 10)
                ,LocalDateTime.of(2020, 3, 30, 12, 0)
                ,LocalDateTime.of(2020, 4, 5, 12, 0), 2, 0);
        //when
        guest.ifPresent(g -> g.addReservationToGuest(reservation));
        Optional<Guest> result = guestRepository.findById(1L);
        //then
        assertEquals(2, result.get().getReservations().size());
    }
}
