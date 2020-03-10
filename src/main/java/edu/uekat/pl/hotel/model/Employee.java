package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
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

    public Employee() {
    }

    public Employee(String firstName, String lastName, boolean isMen, LocalDate birthDate, LocalDate hireDate, String city, String address
                    ,String country, String postCode, String phoneNr, String email, String role){
        this.firstName = firstName;
        this.lastName = lastName;
        this.isMen = isMen;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.city = city;
        this.address = address;
        this.country = country;
        this.postCode = postCode;
        this.phoneNr = phoneNr;
        this.email = email;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean getMen() {
        return isMen;
    }

    public void setMen(boolean men) {
        isMen = men;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNr() {
        return phoneNr;
    }

    public void setPhoneNr(String phoneNr) {
        this.phoneNr = phoneNr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee getReportsTo() {
        return reportsTo;
    }

    public void setReportsTo(Employee reportsTo) {
        this.reportsTo = reportsTo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id.equals(employee.id) &&
                firstName.equals(employee.firstName) &&
                lastName.equals(employee.lastName) &&
                isMen.equals(employee.isMen) &&
                birthDate.equals(employee.birthDate) &&
                hireDate.equals(employee.hireDate) &&
                city.equals(employee.city) &&
                address.equals(employee.address) &&
                country.equals(employee.country) &&
                postCode.equals(employee.postCode) &&
                phoneNr.equals(employee.phoneNr) &&
                email.equals(employee.email) &&
                Objects.equals(reportsTo, employee.reportsTo) &&
                role.equals(employee.role) &&
                Objects.equals(hotel, employee.hotel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, isMen, birthDate, hireDate, city, address, country, postCode, phoneNr, email, reportsTo, role, hotel);
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
