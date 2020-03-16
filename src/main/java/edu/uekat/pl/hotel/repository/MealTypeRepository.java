package edu.uekat.pl.hotel.repository;

import edu.uekat.pl.hotel.model.MealType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealTypeRepository extends JpaRepository<MealType, Long> {

    Optional<MealType> findByMealType(String mealType);
}
