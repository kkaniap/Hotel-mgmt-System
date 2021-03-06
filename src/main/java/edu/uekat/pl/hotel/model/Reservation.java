package edu.uekat.pl.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "roomsReservations",
                joinColumns = {@JoinColumn(name = "reservationId", referencedColumnName = "reservationId")},
                inverseJoinColumns = {@JoinColumn(name = "roomId", referencedColumnName = "roomId")}
                )
    private List<Room> rooms = new ArrayList<>();

    @NonNull
    @Column(nullable = false)
    private LocalDateTime reservationDate;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime dateFrom;

    @NonNull
    @Column(nullable = false)
    private LocalDateTime dateTo;

    @NonNull
    private Integer adults;

    @NonNull
    private Integer children;

    @ManyToOne
    @JoinColumn(name = "mealTypeId")
    private MealType mealType;

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
