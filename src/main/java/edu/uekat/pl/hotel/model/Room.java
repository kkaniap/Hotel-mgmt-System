package edu.uekat.pl.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
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

    @NonNull
    @Column(name = "roomFloor", nullable = false)
    private Integer floor;

    @NonNull
    @Column(nullable = false)
    private Integer roomNumber;

    @NonNull
    @Column(nullable = false)
    private BigDecimal price;

    @ManyToMany(mappedBy = "rooms")
    private List<Reservation> reservations = new ArrayList<>();

    public void addRoomTypeToRoom(RoomType roomType){
        roomType.getRoomList().add(this);
        this.setRoomType(roomType);
    }

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
