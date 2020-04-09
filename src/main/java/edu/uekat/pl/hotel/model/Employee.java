package edu.uekat.pl.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Boolean isMen;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalDate hireDate;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private String phoneNr;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @Column(nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<Reservation>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isMen=" + isMen +
                ", birthDate=" + birthDate +
                ", hireDate=" + hireDate +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", country='" + country + '\'' +
                ", postCode='" + postCode + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", email='" + email + '\'' +
                ", reportsTo=" + (reportsTo==null?"Brak":(reportsTo.getFirstName() + " " + reportsTo.getLastName())) +
                ", role='" + role + '\'' +
                ", hotel=" + (hotel==null?"Brak":hotel.getCode()) +
                '}';
    }
}
