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
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "roomType")
    private List<Room> roomList = new ArrayList<Room>();

    public RoomType() {
    }

    public RoomType(String typeName, Double roomRate, String description){
        this.typeName = typeName;
        this.roomRate = roomRate;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoomType roomType = (RoomType) o;
        return id.equals(roomType.id) &&
                typeName.equals(roomType.typeName) &&
                roomRate.equals(roomType.roomRate) &&
                description.equals(roomType.description) &&
                Objects.equals(roomList, roomType.roomList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, roomRate, description, roomList);
    }

    @Override
    public String toString() {
        return "RoomType{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", roomRate=" + roomRate +
                ", description='" + description + '\'' +
                ", roomList=" + roomList.size() +
                '}';
    }
}
