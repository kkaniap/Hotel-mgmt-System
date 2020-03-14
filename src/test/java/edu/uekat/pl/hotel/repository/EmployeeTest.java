package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    EmployeeRepository employeeRepo;

    static Employee e1,e2,e3;

    @BeforeAll
    static void setUp(){
        e1 = new Employee("Marcin", "Biedronka", true, LocalDate.of(1996,4,22), LocalDate.now(), "Kraków", "Baziowa 10", "Poland"
                        ,"22-321", "321432984", "marbie@gmail.com", "Boss");
        e2 = new Employee("Maciej", "Wrobel", true, LocalDate.of(1981,2,11), LocalDate.now(), "Warszawa", "Wloska 20/1", "Poland"
                        , "31-932", "332332222", "macwro@gmail.com", "Manager");
        e3 = new Employee("Weronika", "Kowalska", false, LocalDate.of(2000,12,5), LocalDate.now(), "Kraków", "Jagodowa 21", "Poland"
                        , "55-200", "434443091", "werkow@gmail.com", "receptionist");
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
}
