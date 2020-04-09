package edu.uekat.pl.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private Long id;

    @Column(name = "hotelCode", unique = true, nullable = false)
    private String code;

    @Column(name = "hotelName", nullable = false)
    private String name;

    @Column(name = "hotelCity", nullable = false)
    private String city;

    @Column(name = "hotelAddress", nullable = false)
    private String address;

    @Column(name = "hotelPostCode", nullable = false)
    private String postCode;

    @Column(name = "hotelStars", nullable = false)
    private Integer stars;

    @Column(name = "hotelCountry", nullable = false)
    private String country;

    @Column(name = "hotelEmail", nullable = false)
    private String email;

    @Column(name = "hotelPhoneNr",nullable = false)
    private String phoneNr;

    @OneToMany(mappedBy = "hotel",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Room> rooms = new ArrayList<Room>();

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
    private List<Employee> employees = new ArrayList<Employee>();

}
