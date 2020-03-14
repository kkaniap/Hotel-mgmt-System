package edu.uekat.pl.hotel.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class MealType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mealTypeId")
    private Long id;
    @Column(nullable = false)
    private String mealType;
    @Column(nullable = false)
    private String description;
    @OneToMany(mappedBy = "mealType")
    private List<Reservation> reservations = new ArrayList<Reservation>();

    public MealType() {
    }

    public MealType(String mealType, String description){
        this.mealType = mealType;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MealType mealType1 = (MealType) o;
        return id.equals(mealType1.id) &&
                mealType.equals(mealType1.mealType) &&
                description.equals(mealType1.description) &&
                Objects.equals(reservations, mealType1.reservations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mealType, description, reservations);
    }

    @Override
    public String toString() {
        return "MealType{" +
                "id=" + id +
                ", mealType='" + mealType + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

}
