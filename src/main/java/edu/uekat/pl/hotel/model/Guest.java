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
public class Guest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "guestId")
    private Long id;

    @NonNull
    @Column(nullable = false, unique = true)
    private String idNumber;

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
    private String country;

    @NonNull
    @Column(nullable = false)
    private String city;

    @NonNull
    @Column(nullable = false)
    private String address;

    @NonNull
    @Column(nullable = false)
    private String postCode;

    @NonNull
    @Column(nullable = false)
    private LocalDate birthDate;

    @NonNull
    @Column(nullable = false)
    private String email;

    @NonNull
    @Column(nullable = false)
    private String phoneNr;

    private String additionalInfo;

    @OneToMany(mappedBy = "guest",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Reservation> reservations = new ArrayList<>();

    public void addReservationToGuest(Reservation reservation){
        reservation.setGuest(this);
        this.getReservations().add(reservation);
    }

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
