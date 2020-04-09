package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Employee;
import edu.uekat.pl.hotel.model.Hotel;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepo;
    @Autowired
    HotelRepository hotelRepository;

    static Employee e1,e2,e3;
    static Hotel h1;

    @BeforeAll
    static void setUp(){
        e1 = new Employee("Marcin", "Biedronka", true, LocalDate.of(1996,4,22), LocalDate.now(), "Kraków", "Baziowa 10", "Poland"
                        ,"22-321", "321432984", "marbie@gmail.com", "Boss");
        e2 = new Employee("Maciej", "Wrobel", true, LocalDate.of(1981,2,11), LocalDate.now(), "Warszawa", "Wloska 20/1", "Poland"
                        , "31-932", "332332222", "macwro@gmail.com", "Manager");
        e3 = new Employee("Weronika", "Kowalska", false, LocalDate.of(2000,12,5), LocalDate.now(), "Kraków", "Jagodowa 21", "Poland"
                        , "55-200", "434443091", "werkow@gmail.com", "receptionist");
        h1 = new Hotel("HT-001", "Hotel Tychy", "Tychy", "Borowa 1", "43-443", 4, "Poland", "hoteltychy@gmail.com"
                ,"548563254");
        e1 = new Employee();
    }

    @Test
    @DisplayName("Save and find employee by first and last name")
    void saveAndFindEmpByFirstAndLastName(){
        employeeRepo.save(e1);
        assertFalse(employeeRepo.findByFirstNameAndLastName("Marcin", "Biedronka").isEmpty());
    }

    @Test
    @DisplayName("try to find not existing employee")
    void findNotExistingEmployee(){
        assertTrue(employeeRepo.findByFirstNameAndLastName("Marcin", "Kowalski").isEmpty());
    }

    @Test
    @DisplayName("save employee with reportsTo")
    void saveEmployeeWithReportsToEquals(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(e1);
        employeeList.add(e2);

        for(Employee e : employeeList){
            e.setReportsTo(e1);
        }

        employeeRepo.saveAll(employeeList);
        Employee boss = employeeRepo.findById(2L).map(Employee::getReportsTo).get();

        assertEquals("Marcin".concat("Biedronka"), boss.getFirstName().concat(boss.getLastName()));
    }

    @Test
    @DisplayName("save employee with reportsTo not equals")
    void saveEmployeeWithReportsToNotEquals(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(e1);
        employeeList.add(e2);

        for(Employee e : employeeList){
            e.setReportsTo(e1);
        }

        employeeRepo.saveAll(employeeList);
        Employee boss = employeeRepo.findById(2L).map(Employee::getReportsTo).get();

        assertNotEquals("Marcin".concat("Kania"), boss.getFirstName().concat(boss.getLastName()));
    }

    @Test
    @DisplayName("save employee with reportsTo not null")
    void saveEmployeeWithReportsToNotNull(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(e1);
        employeeList.add(e2);

        for(Employee e : employeeList){
            e.setReportsTo(e1);
        }

        employeeRepo.saveAll(employeeList);
        Optional<Employee> boss = employeeRepo.findById(2L).map(Employee::getReportsTo);

        assertTrue(boss.isPresent());
    }

    @Test
    @DisplayName("save employee with reportsTo null")
    void saveEmployeeWithReportsToNull(){
        List<Employee> employeeList = new ArrayList<Employee>();

        employeeList.add(e1);
        employeeList.add(e2);

        for(Employee e : employeeList){
            e.setReportsTo(e1);
        }

        employeeRepo.saveAll(employeeList);
        Optional<Employee> boss = employeeRepo.findById(2L).map(Employee::getReportsTo);

        assertFalse(boss.isEmpty());
    }

    @Test
    @DisplayName("From which hotel is Employee")
    void fromWhichHotelIsEmployee(){
        hotelRepository.save(h1);

        e1.setHotel(h1);
        employeeRepo.save(e1);

        assertEquals(1L, employeeRepo.findById(1L).get().getId());
    }
}
