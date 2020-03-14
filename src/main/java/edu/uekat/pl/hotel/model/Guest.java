package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
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
    @OneToMany(mappedBy = "guest")
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public Guest() {
    }

    public Guest(String idNumber, String firstName, String lastName,boolean isMen, String country, String city, String address, String postCode, LocalDate birthDate
                 ,String email, String phoneNr, String additionalInfo){
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMen = isMen;
        this.country = country;
        this.city = city;
        this.address = address;
        this.postCode = postCode;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNr = phoneNr;
        this.additionalInfo = additionalInfo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getMen() {
        return isMen;
    }

    public void setMen(Boolean men) {
        isMen = men;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
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

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return id.equals(guest.id) &&
                idNumber.equals(guest.idNumber) &&
                firstName.equals(guest.firstName) &&
                lastName.equals(guest.lastName) &&
                isMen.equals(guest.isMen) &&
                country.equals(guest.country) &&
                city.equals(guest.city) &&
                address.equals(guest.address) &&
                postCode.equals(guest.postCode) &&
                birthDate.equals(guest.birthDate) &&
                email.equals(guest.email) &&
                phoneNr.equals(guest.phoneNr) &&
                Objects.equals(additionalInfo, guest.additionalInfo) &&
                Objects.equals(reservations, guest.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idNumber, firstName, lastName, isMen, country, city, address, postCode, birthDate, email, phoneNr, additionalInfo, reservations);
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
