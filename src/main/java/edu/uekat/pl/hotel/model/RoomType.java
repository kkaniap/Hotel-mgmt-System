package edu.uekat.pl.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Room_type")
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roomTypeId")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String typeName;

    @NonNull
    @Column(nullable = false)
    private Double roomRate;

    @NonNull
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "roomType", cascade = CascadeType.ALL)
    private List<Room> roomList = new ArrayList<>();

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
