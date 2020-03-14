package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Guest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GuestTest {

    @Autowired
    GuestRepository guestRepository;
    static Guest g1, g2, g3;

    @BeforeAll
    static void setUp(){
        g1 = new Guest("APY2231", "Patryk", "Kania", true, "Poland", "Tychy", "Zimna 10", "43-100", LocalDate.now()
                ,"xkaniax@gmail.com", "558452145", "Administrator");
        g2 = new Guest("AXK2546","Karolina", "Loson", false, "Poland", "Wrocław", "Malinowa", "44-915", LocalDate.now()
                , "karlo@gmail.com", "552365896", "");
        g3 = new Guest("KRW5201", "Karol", "Nowak", true, "Poland", "Katowice", "Asnyka 16/50", "33-421", LocalDate.now()
                , "karnow@gmail.com", "558555201", "Premium guest");
    }

    @Test
    @DisplayName("Save and find by ID number")
    void whenSaveThenFindByIdNumberIsNotNull(){
        guestRepository.save(g1);
        assertNotNull(guestRepository.findByIdNumber("AXY2231"));
    }

    @Test
    @DisplayName("Find not existing guest by ID number")
    void findByIdNumberIsNull(){
        assertTrue(guestRepository.findByIdNumber("KK23321").isEmpty());
    }

    @Test
    @DisplayName("Save and find by first and last name")
    void saveAndFindByFirstAndLastNameIsNotNull(){
        guestRepository.save(g1);
        assertFalse(guestRepository.findByFirstNameAndLastName("Patryk","Kania").isEmpty());
    }

    @Test
    @DisplayName("Find not existing guest by first and last name")
    void findByFirstAndLastNameIsNull(){
        assertTrue(guestRepository.findByFirstNameAndLastName("Karol","Nowak").isEmpty());
    }

    @Test
    @DisplayName("Save 3 guest and find all")
    void saveAndFindAllGuestIsEquals(){
        List<Guest> guestList = new ArrayList<Guest>();
        guestList.add(g1);
        guestList.add(g2);
        guestList.add(g3);

        guestRepository.saveAll(guestList);
        assertEquals(3, guestRepository.findAll().size());
    }

    @Test
    @DisplayName("Save 3 guest and try to find 4 guest")
    void saveAndFindAllGuestIsNotEquals(){
        List<Guest> guestList = new ArrayList<Guest>();
        guestList.add(g1);
        guestList.add(g2);
        guestList.add(g3);

        guestRepository.saveAll(guestList);
        assertNotEquals(4, guestRepository.findAll().size());
    }

}
