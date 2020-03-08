package edu.uekat.pl.hotel.model;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hotelId")
    private Long id;
    @Column(name = "hotelCode")
    private String code;
    @Column(name = "hotelName")
    private String name;
    @Column(name = "hotelCity")
    private String city;
    @Column(name = "hotelAddress")
    private String address;
    @Column(name = "hotelPostCode")
    private String postCode;
    @Column(name = "hotelStars")
    private Integer stars;
    @Column(name = "hotelCountry")
    private String country;
    @Column(name = "hotelEmail")
    private String email;
    @Column(name = "hotelPhoneNr")
    private String phoneNr;

    public Hotel() {
    }

    public Hotel(String code, String name, String city, String address, String postCode, int stars, String country, String email, String phoneNr){
        this.code = code;
        this.name = name;
        this.city = city;
        this.address = address;
        this.postCode = postCode;
        this.stars = stars;
        this.country = country;
        this.email = email;
        this.phoneNr = phoneNr;
    }


}
