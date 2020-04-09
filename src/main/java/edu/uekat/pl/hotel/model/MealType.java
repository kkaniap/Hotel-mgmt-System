package edu.uekat.pl.hotel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MealType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealTypeId")
    private Long id;

    @Column(nullable = false)
    private String mealType;

    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "mealType", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<Reservation>();
}
