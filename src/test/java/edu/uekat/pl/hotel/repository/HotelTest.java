package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Employee;
import edu.uekat.pl.hotel.model.Hotel;
import edu.uekat.pl.hotel.model.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HotelTest {

    @Autowired
    HotelRepository hotelRepo;
    @Autowired
    EmployeeRepository employeeRepo;
    @Autowired
    RoomRepository roomRepo;

    @Test
    @DisplayName("Save and find hotel by code")
    void saveAndFindHotelByCode(){
        //given
        Hotel h1 = new Hotel("HT-001", "Hotel Tychy", "Tychy", "Borowa 1", "43-443", 4, "Poland", "hoteltychy@gmail.com"
                ,"548563254");
        //when
        hotelRepo.save(h1);
        Optional<Hotel> result = hotelRepo.findByCode("HT-001");
        //then
        assertEquals("HT-001".toLowerCase(), result.get().getCode().toLowerCase());
    }

    @Test
    @DisplayName("Find not existing hotel by code")
    void saveAndFindNotExistingHotelByCode(){
        //given
        String code = "HT-002";
        //when
        Optional<Hotel> result = hotelRepo.findByCode(code);
        //then
        assertFalse(result.isPresent());
    }

    @Test
    @DisplayName("Get all employees from hotel")
    @Transactional
    void getAllEmployeesFromHotelTrue(){
        //given
        Optional<Hotel> h1 = hotelRepo.findById(1L);
        //when
        int employees = h1.get().getEmployees().size();
        //then
        assertEquals(2, employees);
    }


    @Test
    @DisplayName("Get all rooms from hotel")
    @Transactional
    void GetAllRoomsFromHotel(){
        //given
        Optional<Hotel> h1 = hotelRepo.findById(1L);
        //when
        int rooms = h1.get().getRooms().size();
        //then
        assertEquals(4, rooms);
    }
}













