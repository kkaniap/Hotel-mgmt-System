package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservationId")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "guestId")
    private Guest guest;
    @ManyToOne
    @JoinColumn(name = "employeeId")
    private Employee employee;
    @ManyToMany
    @JoinTable(name = "roomsReservations",
                joinColumns = {@JoinColumn(name = "reservationId", referencedColumnName = "reservationId")},
                inverseJoinColumns = {@JoinColumn(name = "roomId", referencedColumnName = "roomId")}
                )
    private List<Room> rooms = new ArrayList<Room>();
    @Column(nullable = false)
    private LocalDateTime reservationDate;
    @Column(nullable = false)
    private LocalDateTime dateFrom;
    @Column(nullable = false)
    private LocalDateTime dateTo;
    private Integer adults;
    private Integer children;
    @ManyToOne
    @JoinColumn(name = "mealTypeId")
    private MealType mealType;

    public Reservation() {
    }

    public Reservation(LocalDateTime reservationDate, LocalDateTime dateFrom, LocalDateTime dateTo, int adults, int children){
        this.reservationDate = reservationDate;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.adults = adults;
        this.children = children;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public LocalDateTime getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDateTime reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDateTime getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDateTime dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDateTime getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDateTime dateTo) {
        this.dateTo = dateTo;
    }

    public Integer getAdults() {
        return adults;
    }

    public void setAdults(Integer adults) {
        this.adults = adults;
    }

    public Integer getChildren() {
        return children;
    }

    public void setChildren(Integer children) {
        this.children = children;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(guest, that.guest) &&
                Objects.equals(employee, that.employee) &&
                Objects.equals(rooms, that.rooms) &&
                reservationDate.equals(that.reservationDate) &&
                dateFrom.equals(that.dateFrom) &&
                dateTo.equals(that.dateTo) &&
                Objects.equals(adults, that.adults) &&
                Objects.equals(children, that.children) &&
                Objects.equals(mealType, that.mealType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, guest, employee, rooms, reservationDate, dateFrom, dateTo, adults, children, mealType);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", guest=" + (guest!=null?(guest.getFirstName() + " " + guest.getLastName()):"brak") +
                ", employee=" + (employee!=null?(employee.getFirstName() + " " + employee.getLastName()):"brak") +
                ", rooms=" + rooms.size() +
                ", reservationDate=" + reservationDate +
                ", dateFrom=" + dateFrom +
                ", dateTo=" + dateTo +
                ", adults=" + adults +
                ", children=" + children +
                ", mealType=" + mealType.getMealType() +
                '}';
    }
}
