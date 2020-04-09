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
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestId")
    private Long id;

    @Column(nullable = false, unique = true)
    private String idNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Boolean isMen;

    @Column(nullable = false)
    private String country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String postCode;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNr;

    private String additionalInfo;

    @OneToMany(mappedBy = "guest",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<Reservation>();

    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", idNumber='" + idNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", isMen=" + isMen +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                ", additionalInfo='" + additionalInfo + '\'' +
                ", reservations=" + reservations.size() +
                '}';
    }
}
