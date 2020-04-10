package edu.uekat.pl.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employeeId")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String firstName;

    @NonNull
    @Column(nullable = false)
    private String lastName;

    @NonNull
    @Column(nullable = false)
    private Boolean isMen;

    @NonNull
    @Column(nullable = false)
    private LocalDate birthDate;

    @NonNull
    @Column(nullable = false)
    private LocalDate hireDate;

    @NonNull
    @Column(nullable = false)
    private String city;

    @NonNull
    @Column(nullable = false)
    private String address;

    @NonNull
    @Column(nullable = false)
    private String country;

    @NonNull
    @Column(nullable = false)
    private String postCode;

    @NonNull
    @Column(nullable = false)
    private String phoneNr;

    @NonNull
    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "reportsTo")
    private Employee reportsTo;

    @NonNull
    @Column(nullable = false)
    private String role;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @OneToMany(mappedBy = "employee",
            cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservationToEmployee(Reservation reservation){
        reservation.setEmployee(this);
        this.getReservations().add(reservation);
    }

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
