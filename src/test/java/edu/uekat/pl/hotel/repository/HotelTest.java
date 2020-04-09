package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Employee;
import edu.uekat.pl.hotel.model.Hotel;
import edu.uekat.pl.hotel.model.Room;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HotelTest {

    @Autowired
    HotelRepository hotelRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    RoomRepository roomRepository;

    static Hotel h1;
    static Employee e1,e2,e3;
    static Room r1, r2, r3;

    @BeforeAll
    static void setUp(){
        h1 = new Hotel("HT-001", "Hotel Tychy", "Tychy", "Borowa 1", "43-443", 4, "Poland", "hoteltychy@gmail.com"
                        ,"548563254");
        e1 = new Employee("Marcin", "Biedronka", true, LocalDate.of(1996,4,22), LocalDate.now(), "Kraków", "Baziowa 10", "Poland"
                ,"22-321", "321432984", "marbie@gmail.com", "Boss");
        e2 = new Employee("Maciej", "Wrobel", true, LocalDate.of(1981,2,11), LocalDate.now(), "Warszawa", "Wloska 20/1", "Poland"
                , "31-932", "332332222", "macwro@gmail.com", "Manager");
        e3 = new Employee("Weronika", "Kowalska", false, LocalDate.of(2000,12,5), LocalDate.now(), "Kraków", "Jagodowa 21", "Poland"
                , "55-200", "434443091", "werkow@gmail.com", "receptionist");
        r1 = new Room(1,10,new BigDecimal("80.99"));
        r2 = new Room(1,25,new BigDecimal("50"));
        r3 = new Room(2, 51, new BigDecimal("50"));
    }

    @Test
    @DisplayName("Save and find hotel by code")
    void saveAndFindHotelByCode(){
        hotelRepository.save(h1);
        assertTrue(hotelRepository.findByCode("HT-001").isPresent());
    }

    @Test
    @DisplayName("Save and find not existing hotel by code")
    void saveAndFindNotExistingHotelByCode(){
        hotelRepository.save(h1);
        assertTrue(hotelRepository.findByCode("HT-003").isEmpty());
    }

    @Test
    @DisplayName("Get all employees from hotel true")
    void getAllEmployeesFromHotelTrue(){
        hotelRepository.save(h1);

        List<Employee> employees = List.of(e1, e2, e3);
        for(Employee e : employees){
            e.setHotel(h1);
        }

        employeeRepository.saveAll(employees);
        assertEquals(3, hotelRepository.findById(1L).map(Hotel::getEmployees).get().size());
    }

    @Test
    @DisplayName("Get all employees from hotel false")
    void getAllEmployeesFromHotelFalse(){
        hotelRepository.save(h1);

        List<Employee> employees = List.of(e1, e2, e3);
        for(Employee e : employees){
            e.setHotel(h1);
        }

        employeeRepository.saveAll(employees);
        assertNotEquals(0, hotelRepository.findById(1L).map(Hotel::getEmployees).get().size());
    }

    @Test
    @DisplayName("Get all rooms from hotel")
    void GetAllRoomsFromHotel(){
        hotelRepository.save(h1);

        List<Room> roomList = List.of(r1, r2, r3);
        for (Room r : roomList){
            r.setHotel(h1);
        }

        roomRepository.saveAll(roomList);
        assertEquals(3, hotelRepository.findById(1L).map(Hotel::getEmployees).get().size());
    }

    @Test
    @DisplayName("Get all rooms from hotel false")
    void GetAllRoomsFromHotelFalse(){
        hotelRepository.save(h1);

        List<Room> roomList = List.of(r1, r2, r3);
        for (Room r : roomList){
            r.setHotel(h1);
        }

        roomRepository.saveAll(roomList);
        assertNotEquals(0, hotelRepository.findById(1L).map(Hotel::getEmployees).get().size());
    }

}













