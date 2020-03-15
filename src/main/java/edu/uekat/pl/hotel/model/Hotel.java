package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
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
    @OneToMany(mappedBy = "hotel")
    private List<Room> rooms = new ArrayList<Room>();;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER)
    private List<Employee> employees = new ArrayList<Employee>();

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public Integer getStars() {
        return stars;
    }

    public void setStars(Integer stars) {
        this.stars = stars;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return id.equals(hotel.id) &&
                code.equals(hotel.code) &&
                name.equals(hotel.name) &&
                city.equals(hotel.city) &&
                address.equals(hotel.address) &&
                postCode.equals(hotel.postCode) &&
                stars.equals(hotel.stars) &&
                country.equals(hotel.country) &&
                email.equals(hotel.email) &&
                phoneNr.equals(hotel.phoneNr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code, name, city, address, postCode, stars, country, email, phoneNr);
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", postCode='" + postCode + '\'' +
                ", stars=" + stars +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", phoneNr='" + phoneNr + '\'' +
                '}';
    }
}
