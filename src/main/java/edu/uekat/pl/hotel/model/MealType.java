package edu.uekat.pl.hotel.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class MealType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealTypeId")
    private Long id;

    @NonNull
    @Column(nullable = false)
    private String mealType;

    @NonNull
    @Column(nullable = false)
    private String description;

    @OneToMany(mappedBy = "mealType", cascade = CascadeType.ALL)
    private List<Reservation> reservations = new ArrayList<>();
}
