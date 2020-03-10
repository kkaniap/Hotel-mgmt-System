package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Room_type")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomTypeId")
    private Long id;
    @Column(nullable = false)
    private String typeName;
    @Column(nullable = false)
    private Double roomRate;
    @OneToMany(mappedBy = "roomType")
    private List<Room> roomList = new ArrayList<Room>();

    public RoomType() {
    }

    public RoomType(String typeName, Double roomRate){
        this.typeName = typeName;
        this.roomRate = roomRate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Double getRoomRate() {
        return roomRate;
    }

    public void setRoomRate(Double roomRate) {
        this.roomRate = roomRate;
    }

    public List<Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Room> roomList) {
        this.roomList = roomList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return id.equals(roomType.id) &&
                typeName.equals(roomType.typeName) &&
                roomRate.equals(roomType.roomRate) &&
                Objects.equals(roomList, roomType.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, roomRate, roomList);
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", roomRate=" + roomRate +
                '}';
    }
}
