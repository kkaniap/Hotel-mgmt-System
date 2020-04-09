package edu.uekat.pl.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomId")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "roomTypeId")
    private RoomType roomType;

    @Column(name = "roomFloor", nullable = false)
    private Integer floor;

    @Column(nullable = false)
    private Integer roomNumber;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "rooms")
    private List<Reservation> reservations = new ArrayList<Reservation>();

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", hotel code=" + hotel.getCode() +
                ", roomTypeId=" + roomType.getId() +
                ", floor=" + floor +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}
