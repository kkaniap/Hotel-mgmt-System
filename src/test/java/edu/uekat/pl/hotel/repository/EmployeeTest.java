package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Employee;
import edu.uekat.pl.hotel.model.Hotel;
import edu.uekat.pl.hotel.model.Reservation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepo;
    @Autowired
    HotelRepository hotelRepository;

    @Test
    @DisplayName("Save and find employee by first and last name")
    void saveAndFindEmpByFirstAndLastName(){
        //given
        Employee e1 = new Employee("Patryk", "Kania", true, LocalDate.of(1996,3, 2), LocalDate.of(2010, 10,10),
                "Tychy", "Malinowa 20", "Poland", "43-100", "+48531281648", "xkaniax@gmail.com","Szef");
        //when
        employeeRepo.save(e1);
        List<Employee> employees = employeeRepo.findByFirstNameAndLastName(e1.getFirstName(), e1.getLastName());
        //then
        assertEquals(employees.get(0).getFirstName().toLowerCase(), e1.getFirstName().toLowerCase());
        assertEquals(1, employees.size());
    }

    @Test
    @DisplayName("try to find not existing employee")
    void findNotExistingEmployee(){
        //given
        String name = "Marcin";
        String lastName = "Kania";
        //when
        List<Employee> employees = employeeRepo.findByFirstNameAndLastName(name, lastName);
        //then
        assertEquals(0, employees.size());
    }

    @Test
    @DisplayName("save employee with reportsTo")
    void saveEmployeeWithReportsTo(){
        //given
        Employee e1 = new Employee("Witold", "Kania", true, LocalDate.of(1996,3, 2), LocalDate.of(2010, 10,10),
                "Tychy", "Malinowa 20", "Poland", "43-100", "+48531281648", "xkaniax@gmail.com","Szef");
        Employee e2 = new Employee("Karol", "Nowak", true, LocalDate.of(1995, 2, 11), LocalDate.of(2013, 1,15),
                "Tychy", "Poziomkowa 10", "Poland", "43-100", "+48532148589", "karolnowak@gmail.com","Recepcjonista");
        List<Employee> employeeList = List.of(e1,e2);
        //when
        for(Employee e : employeeList){
            e.setReportsTo(e1);
        }
        employeeRepo.saveAll(employeeList);
        Employee boss = employeeRepo.findById(7L).map(Employee::getReportsTo).get();
        Employee boss2 = employeeRepo.findById(8L).map(Employee::getReportsTo).get();
        //then
        assertEquals("Witold".concat("Kania").toLowerCase(), boss.getFirstName().concat(boss.getLastName()).toLowerCase());
        assertEquals("Witold".concat("Kania").toLowerCase(), boss2.getFirstName().concat(boss2.getLastName()).toLowerCase());
    }

    @Test
    @DisplayName("From which hotel is Employee")
    void fromWhichHotelIsEmployee(){
        //given
        Optional<Employee> e1 = employeeRepo.findById(1L);
        //when
            Hotel h1 = e1.get().getHotel();
        //then
        assertEquals(1L, h1.getId());
    }

    @Test
    @DisplayName("Save employee with reservations and find them")
    @Transactional
    void saveAndFindAllReservation_Employee(){
        //given
        Optional<Employee> employee = employeeRepo.findById(2L);
        Reservation reservation = new Reservation(LocalDateTime.of(2020,3, 21, 10, 10)
                ,LocalDateTime.of(2020, 3, 30, 12, 0)
                ,LocalDateTime.of(2020, 4, 5, 12, 0), 2, 0);
        //when
        employee.ifPresent(e -> e.addReservationToEmployee(reservation));
        Optional<Employee> result = employeeRepo.findById(2L);
        //then
        assertEquals(2, result.get().getReservations().size());
    }

}
