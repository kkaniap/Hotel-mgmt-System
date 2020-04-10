package edu.uekat.pl.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private Long id;

    @NonNull
    @Column(name = "hotelCode", unique = true, nullable = false)
    private String code;

    @NonNull
    @Column(name = "hotelName", nullable = false)
    private String name;

    @NonNull
    @Column(name = "hotelCity", nullable = false)
    private String city;

    @NonNull
    @Column(name = "hotelAddress", nullable = false)
    private String address;

    @NonNull
    @Column(name = "hotelPostCode", nullable = false)
    private String postCode;

    @NonNull
    @Column(name = "hotelStars", nullable = false)
    private Integer stars;

    @NonNull
    @Column(name = "hotelCountry", nullable = false)
    private String country;

    @NonNull
    @Column(name = "hotelEmail", nullable = false)
    private String email;

    @NonNull
    @Column(name = "hotelPhoneNr",nullable = false)
    private String phoneNr;

    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Room> rooms = new ArrayList<>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<>();

}
