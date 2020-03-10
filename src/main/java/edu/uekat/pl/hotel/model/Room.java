package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity

public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "hotelId")
    private Hotel hotel;
    private Long roomTypeId;
    @Column(name = "roomFloor", nullable = false)
    private Integer floor;
    @Column(nullable = false)
    private Integer roomNumber;
    @Column(nullable = false)
    private BigDecimal price;

    public Room() {
    }

    public Room(int floor, int roomNumber, BigDecimal price) {
        this.floor = floor;
        this.roomNumber = roomNumber;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return id.equals(room.id) &&
                hotel.equals(room.hotel) &&
                roomTypeId.equals(room.roomTypeId) &&
                floor.equals(room.floor) &&
                roomNumber.equals(room.roomNumber) &&
                price.equals(room.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hotel, roomTypeId, floor, roomNumber, price);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", hotel code=" + hotel.getCode() +
                ", roomTypeId=" + roomTypeId +
                ", floor=" + floor +
                ", roomNumber=" + roomNumber +
                ", price=" + price +
                '}';
    }
}
